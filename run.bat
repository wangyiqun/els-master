@echo off
echo ɾ���ϴα����ļ�
del .\src\package1\*.class
del .\src\shapes\*.class
echo �ϴα����ļ�ɾ�����
javac -cp src src\package1\Start.java
echo ���±������
echo ��ʼ����
java -cp src package1.Start
pause