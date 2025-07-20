Setup SQL Server + Java spring boot connetion

1 Tải SQL Server 2019 Express -> SQL2019-SSEI-Expr -> Install
2 Tải SSMS -> vs_SSMS -> Install
3 Kết nối SSMS -> Server
	+ Check hostname (Mở cmd -> hostname)
	+ Mở SSMS -> Connect
		+ Server Name: hostname\SQLEXPRESS
		+ Authen: Windows
		+ Connect
4 Kiểm tra TCP & port 1433
	+ Mở SQL Server Configuration Manager
	+ Mở Network > Protocol > TCP/IP > Enable
	+ Kiểm tra port: IPAll > TCP Dynamic Ports > 1433
	+ Lỗi thường gặp:
		The TCP/IP connection to the host localhost, port 1433 has failed. Error: "Connection refused: getsockopt. Verify the connection properties. Make sure that an instance of SQL Server is running on the host and accepting TCP/IP connections at the port. Make sure that TCP connections to the port are not blocked by a firewall
	+ Nguyên nhân:
		+ Chưa Enable TCP/IP
		+ Đã Enable TCP/IP, nhưng kết nối sai port
	+ Bỏ SSL -> set encrypt = false
		+ Lỗi: "encrypt" property is set to "true" and "trustServerCertificate" property is set to "false" but the driver could not establish a secure connection to SQL Server by using Secure Sockets Layer (SSL) encryption: Error: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target. ClientConnectionId:1f6ac3a7-400d-417d-8584-9ade838ab7fd
	+ Tạo tài khoản SQL Login
		+ Login bằng tài khoản Windows
		+ Security > Logins > New
			+ Name
			+ SQL auth > Pass > Bỏ must change > Default DB
			+ User mapping > chọn DB > Chọn role: db_owner
			+ OK
		+ Login lại bằng tài khoản mới tạo
5 Properties cho Spring boot
	spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=student;encrypt=false;
	spring.datasource.username=student
	spring.datasource.password=12345678
	spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect

6 Start Spring Boot
