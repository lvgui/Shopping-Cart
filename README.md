# fileOperate
文件输出目录操作
File
+ exists()	判断路径是否存在
+ isDirectory() 判断是否是目录
+ listFiles() 输出文件列表
+ getCanonicalPath() 返回此抽象路径名的规范形式

用getParent()等方法有一定的弊端不规范，用getCanonicalPath()比较全面
