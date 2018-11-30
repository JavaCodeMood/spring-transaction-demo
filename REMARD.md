#�����壺
����ָ�߼��ϵ�һ�����,�������Ҫôȫ���ɹ�,Ҫôȫ��ʧ��.
                                                  
#��������ԣ� 
###1. ԭ���� -> ָ������һ�����ɷָ�Ĺ�����λ�������еĲ���Ҫô��������Ҫô���������� 

###2. һ���� -> ָ����ǰ������ݵ������Ա��뱣��һ�¡� 

###3. ������ -> ָ����û������������ݿ�ʱ��һ���û��������ܱ������û������������ţ������������֮������Ҫ������롣 

###4. �־��� -> ָһ������һ�����ύ���������ݿ������ݵĸı���������Եģ���ʹ���ݿⷢ������Ҳ��Ӧ�ö������κ�Ӱ�졣
                                    
#Spring��������߲������Ҫ���������ӿڣ�
###PlatformTransactionManager�����������

###TransactionDefinition����������Ϣ(������뼶�𡢴�����Ϊ����ʱ��ֻ��)��TransactionDefinition��ʵ���ౣ���˶����������������Ϣ�������ʵ����Manager��ȡ��������ִ����������Ķ���

###TransactionStatus�������������״̬
                
#SpringΪ��ͬ�ĳ־û�����ṩ�˲�ͬPlatformTransactionManager�ӿ�ʵ��
###1. org.springframework.jdbc.datasource.DataSourceTransactionManager ����> ��ʹ��Spring JDBC��iBatis���г־û�����ʱʹ��

###2. org.springframework.orm.hibernate3.HibernateTransactionManager ����> ��ʹ��Hibernate3.0�汾���г־û�����ʱʹ��

###3. org.springframework.orm.jpa.JpaTransactionManager ����> ��ʹ��JPA���г־û�ʱʹ��

###4. org.springframework.jdo.JdoTransactionManager ����> ���־û�������jdoʱʹ��

###5. org.springframework.transaction.jta.JtaTransactionManager ����> ʹ��һ��JTAʵ��������������һ�������Խ�����Դʱ����ʹ��
      
#������������Ǹ����ԣ�����������������ظ������ö�������
## �����
     һ�������ȡ����һ������û���ύ�����ݣ������Щ���ݱ��ع������ȡ������������Ч�ġ�
## �����ظ�����
     ��ͬһ�������У���ζ�ȡͬһ���ݣ���������һ�������Ѿ����µ����ݣ����·��صĽ��������ͬ��
## ������ö���
        һ�������ȡ���м�¼����һ���������һЩ��¼���ö��ͷ����ˣ��ں����Ĳ�ѯ�У���һ������ͻᷢ��ԭ��û�еļ�¼��

#Spring����ĸ��뼶��
##1. DEFAULT : ʹ�ú�����ݿ�Ĭ�ϵĸ��뼶��spring�е�ѡ���

##2. READ_UNCOMMITTED : �������ȡ��û���ύ�ĸı��˵����ݣ����ܻᵼ��������ö��������ظ���

##3. READ_COMMITTED : �����ڲ��������Ѿ��ύ���ȡ���ݣ����Է�ֹ��������ö��Ͳ����ظ����Կ��ܷ���

##4. REPEATABLE_READ : ����ͬ�ֶεĶ�ζ�ȡ��һ�µģ��������ݱ��������ı䡣���Է�ֹ����������ظ��������ǻö��Կ��ܷ���

##5. SERIALIZABLE : ��߸��뼶������ȫ����ACID�ĸ��뼶��ȷ��������������ö��������ظ������������еĸ��뼶�����������ģ����ǵ��͵�ͨ����ȫ�������������漰�����ݱ�����ɵ�
                              
###MySqlĬ�ϵ�������뼶��ΪREPEATABLE_READ 
###OracleĬ�ϵ�������뼶��ΪREAD_COMMITTED

#Spring����Ĵ�����Ϊ
## ���񴫲���ΪҪ��������⣺���ҵ��㷽��֮���໥���õ�����
     ҵ���������������Ķ��������һ�����ʱ����δ���������������Ĺ�ϵ�����⣬������˵��������δ��ݵ����⡣
    
#���񴫲���Ϊ����
##1. PROPAGATION_REQUIRED : ֧�ֵ�ǰ������������ھ��½�һ��
##2. PROPAGATION_SUPPORTS : ֧�ֵ�ǰ������������ڣ��Ͳ�ʹ������
##3. PROPAGATION_MANDATORY : ֧�ֵ�ǰ������������ڣ��׳��쳣

##4. PROPAGATION_REQUIRES_NEW : �����������ڣ�����ǰ���񣬴���һ���µ�����
##5. PROPAGATION_NOT_SUPPORTED : �Է�����ʽ���У������������ڣ�����ǰ����
##6. PROPAGATION_NEVER : �Է��������У������������ڣ��׳��쳣

##7. PROPAGATION_NESTED : �����ǰ������ڣ���Ƕ������ִ��

###1.	֧�ֵ�ǰ���񣬼������������뵱ǰ����������񲻴��ڷֱ����½�һ�����񣬲�ʹ�������׳��쳣������Ϊ��
###2.	��֧�ֵ�ǰ���񣬼����������������������ڷֱ����½�һ�����񣬲�ʹ�������׳��쳣������Ϊ��
###3.	�����ǰ������ڣ���������������Ϊ��ǰ��������������У�������������ʱ����ǰ�����¼һ������㣬�����񲻱�����͵�ǰ����һ���ύ��ع��������񱨴�������Զ��������õ�ǰ����ع�����������ʼ�㣻

###TransactionStatus�ӿ�������¼�����״̬ �ýӿڶ�����һ�鷽��,������ȡ���ж��������Ӧ״̬��Ϣ. 
###ƽ̨���������(PlatformTransactionManager)�����TransactionDefinition�ж����������Ϣ(�������뼶�𡢴�����Ϊ)����������Ĺ���,�ڹ����Ĺ�����������ܲ����˱������������µ���������,��ô��Щ��Ϣ�����¼��TransactionStatus�Ķ�����.

#Spring����������ֳ�������:
## ���ʽ�������
		* �ֶ���д��������������.(����ʹ��)
## ����ʽ�������:
		* ����TransactionProxyFactoryBean�ķ�ʽ.(����ʹ��)
			* ��ҪΪÿ�����������������,����һ��TransactionProxyFactoryBean������ǿ.
		* ����AspectJ��XML��ʽ.(����ʹ��)
			* һ�����ú�֮��,���ϲ���Ҫ�����κζ���
		* ����ע�ⷽʽ.(����ʹ��)
			* ���ü�,��Ҫ��ҵ���������һ��@Transactional��ע��.











