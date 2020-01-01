# JSP实训作业

## 项目部署

在/blog-jsp/src/jdbc/connect/DataBaseInfo.java 修改数据库配置信息

访问 http://localhost:8080/blog-jsp/index


## 前台页面展示

![首页](doc/image/首页.png)

![文章](doc/image/文章.png)

![文章详细]](doc/image/文章详细.png)

![标签](doc/image/标签.png)

## sql语句

- 文件表


```sql
create table file
(
	id int auto_increment,
	name varchar(255) null comment '名字',
	url varchar(255) null comment 'url地址',
	type int null comment '类型',
	constraint file_pk
		primary key (id)
)
comment '文件表';
```

## 后台编写完成

**主要功能**

+ **文件管理**
  
  * 文件上传
  
	![文件上传](doc/image/后台/文件上传.png)

  * 文件列表（查看 下载 删除）
  
	![文件列表](doc/image/后台/文件列表.png)

- **文章管理**
  
  * 文章编写
  
	![文章编写](doc/image/后台/编写文章.png)
  
  * 文章列表（查看，删除）
  
	![文章列表](doc/image/后台/文件列表.png)

  * about页面编写（前台about页面展示信息）
  
	![about页面编写](doc/image/后台/about编写.png)

- **分类管理**
 
  * 分类列表

  * 添加分类

  * 修改分类

  * 删除分类
  
  ![分类管理](doc/image/后台/分类管理.png)

+ **标签管理**
  
  * 标签列表

  * 修改标签

  * 删除标签
  
  ![分类管理](doc/image/后台/标签管理.png)