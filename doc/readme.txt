1 项目框架
  playFramework2+spring+mybaits+mysql
2 操作命令
  2.1 前置条件
      安装play框架，并且在用户环境变量中配置play的bin目录。
      安装sbt,并且在用户环境变量中配置sbt的bin目录
  2.2 调试方式
      1.进入项目所在目录，如项目为:d:\workspace\HttpServers
      则进入到d:\workspace,启动调试play debug,然后在Play命令行中运行run
      2.在Intellij Idea中远程调试项目
3 添加依赖包
  1.在build.sbt中添加项目依赖的Jar包
  进入项目所在的目录，运行sbt，执行sbt的命令clean和compile，则会下载依赖的jar包。
  2.在sbt命令行中运行gen-idea，则产生idea项目的依赖包。

4 项目文件说明
  4.1 CustomizeGlobal为启动play框架时，加载spring框架
  4.2 application.conf文件为play框架的配置文件
      配置spring配置文件和属性文件
      #spring
      spring.context.file="D:/workspace/HttpServer/conf/main.xml"
  4.3 spring的属性配置文件 conf/main.properties

