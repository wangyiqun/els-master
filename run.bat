@echo off
echo 删除上次编译文件
del .\src\package1\*.class
del .\src\shapes\*.class
echo 上次编译文件删除完成
javac -cp src src\package1\Start.java
echo 重新编译完成
echo 开始运行
java -cp src package1.Start
pause