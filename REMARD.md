#事务定义：
事务指逻辑上的一组操作,这组操作要么全部成功,要么全部失败.
                                                  
#事务的特性： 
###1. 原子性 -> 指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。 

###2. 一致性 -> 指事务前后的数据的完整性必须保持一致。 

###3. 隔离性 -> 指多个用户并发访问数据库时，一个用户的事务不能被其他用户的事务所干扰，多个并发事务之间数据要互相隔离。 

###4. 持久性 -> 指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，即使数据库发生故障也不应该对其有任何影响。
                                    
#Spring事务管理高层抽象主要包括三个接口：
###PlatformTransactionManager：事务管理器

###TransactionDefinition：事务定义信息(事务隔离级别、传播行为，超时，只读)，TransactionDefinition的实现类保存了对事务管理的配置信息，该类的实例被Manager读取用来创建执行事务管理的对象；

###TransactionStatus：事务具体运行状态
                
#Spring为不同的持久化框架提供了不同PlatformTransactionManager接口实现
###1. org.springframework.jdbc.datasource.DataSourceTransactionManager ——> 在使用Spring JDBC或iBatis进行持久化数据时使用

###2. org.springframework.orm.hibernate3.HibernateTransactionManager ——> 在使用Hibernate3.0版本进行持久化数据时使用

###3. org.springframework.orm.jpa.JpaTransactionManager ——> 在使用JPA进行持久化时使用

###4. org.springframework.jdo.JdoTransactionManager ——> 当持久化机制是jdo时使用

###5. org.springframework.transaction.jta.JtaTransactionManager ——> 使用一个JTA实现来管理事务，在一个事务跨越多个资源时必须使用
      
#事务如果不考虑隔离性，会引发脏读、不可重复读、幻读等问题
## 脏读：
     一个事务读取到另一个事务还没有提交的数据，如果这些数据被回滚，则读取到的数据是无效的。
## 不可重复读：
     在同一个事务中，多次读取同一数据，读到了另一个事务已经更新的数据，导致返回的结果有所不同。
## 虚读，幻读：
        一个事务读取几行记录后，另一个事务插入一些记录，幻读就发生了，在后来的查询中，第一个事务就会发现原来没有的记录。

#Spring事务的隔离级别
##1. DEFAULT : 使用后端数据库默认的隔离级别（spring中的选择项）

##2. READ_UNCOMMITTED : 允许你读取还没有提交的改变了的数据，可能会导致脏读、幻读、不可重复读

##3. READ_COMMITTED : 允许在并发事务已经提交后读取数据，可以防止脏读，但幻读和不可重复读仍可能发生

##4. REPEATABLE_READ : 对相同字段的多次读取是一致的，除非数据被事务本身改变。可以防止脏读、不可重复读，但是幻读仍可能发生

##5. SERIALIZABLE : 最高隔离级别，它完全服从ACID的隔离级别，确保不发生脏读、幻读、不可重复读。这在所有的隔离级别中是最慢的，它是典型的通过完全锁定在事务中涉及的数据表来完成的
                              
###MySql默认的事务隔离级别为REPEATABLE_READ 
###Oracle默认的事务隔离级别为READ_COMMITTED

#Spring事务的传播行为
## 事务传播行为要解决的问题：解决业务层方法之间相互调用的问题
     业务层中添加了事务的多个方法被一起调用时，如何处理各方法间事务的关系的问题，具体来说是事务如何传递的问题。
    
#事务传播行为级别
##1. PROPAGATION_REQUIRED : 支持当前事务，如果不存在就新建一个
##2. PROPAGATION_SUPPORTS : 支持当前事务，如果不存在，就不使用事务
##3. PROPAGATION_MANDATORY : 支持当前事务，如果不存在，抛出异常

##4. PROPAGATION_REQUIRES_NEW : 如果有事务存在，挂起当前事务，创建一个新的事务
##5. PROPAGATION_NOT_SUPPORTED : 以非事务方式运行，如果有事务存在，挂起当前事务
##6. PROPAGATION_NEVER : 以非事务运行，如果有事务存在，抛出异常

##7. PROPAGATION_NESTED : 如果当前事务存在，则嵌套事务执行

###1.	支持当前事务，即事务存在则加入当前事务，如果事务不存在分别有新建一个事务，不使用事务，抛出异常三种行为；
###2.	不支持当前事务，即独立运行事务，如果事务存在分别有新建一个事务，不使用事务，抛出异常三种行为；
###3.	如果当前事务存在，则将自身的事务作为当前事务的子事务运行，在运行子事务时，当前事务记录一个保存点，子事务不报错则和当前事务一起提交或回滚，子事务报错则根据自定义配置让当前事务回滚到保存点或起始点；

###TransactionStatus接口用来记录事务的状态 该接口定义了一组方法,用来获取或判断事务的相应状态信息. 
###平台事务管理器(PlatformTransactionManager)会根据TransactionDefinition中定义的事务信息(包括隔离级别、传播行为)来进行事务的管理,在管理的过程中事务可能产生了保存点或事务是新的事务等情况,那么这些信息都会记录在TransactionStatus的对象中.

#Spring将事务管理分成了两类:
## 编程式事务管理
		* 手动编写代码进行事务管理.(很少使用)
## 声明式事务管理:
		* 基于TransactionProxyFactoryBean的方式.(很少使用)
			* 需要为每个进行事务管理的类,配置一个TransactionProxyFactoryBean进行增强.
		* 基于AspectJ的XML方式.(经常使用)
			* 一旦配置好之后,类上不需要添加任何东西
		* 基于注解方式.(经常使用)
			* 配置简单,需要在业务层上添加一个@Transactional的注解.












