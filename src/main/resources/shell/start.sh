#!/bin/bash
echo "Stopping SpringBoot Application..."
pid=$(ps -ef|grep -i framework-0.0.1-SNAPSHOT.jar |grep -v "grep"|awk '{print $2}')
echo "获取pid成功..."+$pid
  if [ -n "$pid" ];
   then 	kill -9 $pid
    echo '解除端口占用...'
    fi

file="/opt/soft/jenkins-demo.jar"
    if [ -f "$file" ];
        then
        echo '开始移动文件'
        mv /root/.jenkins/workspace/framework/target/framework-0.0.1-SNAPSHOT.jar /data/back-framework-jar/framework-0.0.1-SNAPSHOT.jar.bak
        fi
        echo '移动成功'

echo '授予当前用户权限'
 chmod 777 /root/.jenkins/workspace/framework/target/framework-0.0.1-SNAPSHOT.jar
 echo '执行......'
 BUILD_ID=dontkillMe nohup java -jar /root/.jenkins/workspace/framework/target/framework-0.0.1-SNAPSHOT.jar &