# Student_Information_System
简单的IKUN学生信息管理系统基于JAVAGUI，mybatis和mysql

项目中含有mybatis映射文件以及数据库文件

Java实现系统操作

—信息管理系统

前言 

随着社会的发展，教育事业已经越来越受到社会的关注，教育机构也越来越庞大和复杂。学生人数不断增加，各种各样的数据信息让工作人员感到头疼，无法及时地更新数据信息，无法获得最快最新的信息，查询效率低下，工作效率下降。随着科学技术的不断提高，计算机科学也日渐成熟，其强大的功能已为人们深刻认识，它已进入人类社会的各个领域并发挥着越来越重要的作用。作为计算机应用的一部分，使用计算机对学生信息进行管理，具有手工管理所无法比拟的优点。例如：检索迅速、查找方便、可靠性高、存储量大、保密性好、寿命长、成本低等。这些优点能够极大地提高学生信息管理的效率，也是学校的科学化、正规化管理，该系统具有良好的可操作性，功能模块齐全，用户使用简单。因此，开发这样一套学生信息管理系统成为很有必要的事情。
             
1 Java实训目的及要求

1.1实训目的

对Java编程技术的巩固以及强化，将所学的各类技术以及知识整合到一起。

1.2实训要求

能充分的掌握Java编程技术，对该项目能够实现页面的展示，以及数据库的连接和增删改查操作等。

2 系统页面的设计与实现

2.1 登录页面的设计与实现

登录页面采用JavaGUI技术进行页面设计。登录页面有LOGO，用户名登录文本框，密码输入文本框，验证码确认文本框以及注册按钮等组件构成。
 
 
 ![image](https://user-images.githubusercontent.com/105136363/230276418-6ba3cb41-4b9c-4f42-b9a0-cde508b27bbc.png)
图表 1 登录界面示意图

登录的实现首页在输入用户名，密码和验证码之后。先进行验证码的判断，如果验证码判断失败则直接判定为登录失败，重新进入登录环节，不在进行下一步程序的执行。若验证码判断成功则进行获取输入的用户名信息和密码，在对数据库中存有的用户进行校验是否存在该用户。如果存有则登录页面关闭，进入主界面。若不存在则提示用户名或密码错误，此时用户可以重新登录或者点击注册按钮进行注册。

2.2  注册页面的设计与实现

注册页面则是在登录界面点击注册按钮后显示由用户名注册文本框，密码输入文本框，验证码确认文本框以及重置按钮等组件构成。
 
 ![image](https://user-images.githubusercontent.com/105136363/230276469-b030eb11-02f5-4ab9-a591-8fc702a6292f.png)
图表 3 注册页面示意图

注册页面的实现首页是在登录页面点击注册按钮才能跳转到注册页面中，然后在输入需要注册的用户名，密码和正确的验证码之后。先进行验证码的判断，如果验证码判断失败则直接判定为注册失败，重新进入注册环节，不在进行下一步程序的执行。若验证码判断成功则进行获取输入的用户名信息和密码，在对数据库中存有的用户进行校验是否存在该用户。如果存有则提示已存在该用户，从而取消注册。若不存在则在数据库中进行添加该用户数据，注册成功后自动跳转到登录页面。
重置按钮则是清空当前所填内容，从而达到重置效果。

2.3 主界面的设计与实现

主界面的UI设计则是主要由JmenuBar、Jmenu以及JmenuItem构造。
主要分为系统操作、学生信息管理、老师信息管理、班级信息管理以及关于我们等选项菜单。不同的菜单选项都会弹出不同的界面从而实现相对应的功能。
 
 ![image](https://user-images.githubusercontent.com/105136363/230276505-e7e416c3-6b72-44b0-80cb-d987e0a13c76.png)
图表 5 主界面示意图

主界面的实现分别由系统操作、学生信息管理、老师信息管理、班级信息管理以及关于我们等需求来实现，系统的操作分为退出系统和修改密码两种操作。
退出系统则是使用System.exit(0)方式进行实现。修改密码则是进入修改界面 


![image](https://user-images.githubusercontent.com/105136363/230276556-58f225f6-c8b9-40b4-a502-79f0404d3c47.png)
图表 6 修改密码界面示意图

首先进行原密码的判断，其次进行两次修改密码的判断，两者都为TURE则密码修改成功。

学生信息管理系统分为学生的添加以及学生列表的查询
  
  ![image](https://user-images.githubusercontent.com/105136363/230276588-698fb484-aee1-4847-b007-0e6e18c3c1df.png)
图表 7 学生信息管理示意图

对学生进行数据库的添加以及删除和修改功能，列表查询则是查询所用的学生信息。

教师管理与学生系统相似。

班级管理，能够对班级进行添加以及查询所用班级信息等操作
  
  
  ![image](https://user-images.githubusercontent.com/105136363/230276608-297310fa-f300-4962-92d1-b8a6e7a6d791.png)
图表 8 班级管理示意图

3 数据库的连接与操作数据库

3.1 数据库的连接

数据库的连接则是放弃较为复杂的JDBC操作，而是使用apache所开源的mybatis较为优秀的持久层框架，Mybatis免除的几乎所用JDBC的复杂操作。
 
3.2 操作数据库

该系统需要对数据库进行增删改查等操作，则使用到项目中所创建的MAPPER映射文件所采用的注解开发模式
 
4 程序的设计思路

4.1 程序设计思路

首先由UI层进行架构，其次对业务层以及数据层进行添加，最后进行整体项目测试。分开处理能够更好，更快速的完成项目的整体构造。
 
 ![image](https://user-images.githubusercontent.com/105136363/230276649-c1cc5b91-500b-4a24-82d7-66006fdd024b.png)
4.2 程序必要的jar包

连接数据库的mysql-connector-java-8.0.29.jar包

操作数据库的mybatis-3.5.0.jar包
 
4.3 程序中的工具类

工具类：

1.	用户数据库操作服务工具类

2.	学生数据库操作服务工具类

3.	教师数据库操作服务工具类

4.	班级数据库操作服务工具类

5.	验证码生成工具类

6.	Sqlfactory生成工具类
 


