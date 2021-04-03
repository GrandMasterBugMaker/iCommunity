# 各服务器内外网IP

- 阿里云
    - 外网：123.57.86.122
    - 内网：172.30.117.84
- 百度云
    - 外网：120.48.0.127
    - 内网：192.168.16.4
- 腾讯云
    - 外网：192.144.237.32
    - 内网：172.21.0.8
- 华为云
    - 外网：121.36.20.59
    - 内网：192.168.0.148

# zookeeper配置`/etc/hosts`

- 120.48.0.127 node1
- 192.144.237.32 node2
- 121.36.20.59 node3

# zookeeper配置`conf/zoo.cfg`

- server.1=120.48.0.127:2888:3888
- server.2=192.144.237.32:2888:3888
- server.3=121.36.20.59:2888:3888

# zookeeper路径

```shell
cd /home/bailingnan/apache-zookeeper-3.7.0-bin/bin
```

# kafka路径

```shell
cd /home/bailingnan/kafka_2.13-2.7.0/
```

# zookeeper命令

## 启动

```shell
zkServer.sh -daemon start
```

## 状态

```shell
zkServer.sh status
```

## 停止

```shell
zkServer.sh stop
```

# kafka命令

## 修改配置

```shell
vim /home/bailingnan/kafka_2.13-2.7.0/config/server.properties
```

## 启动kafka

```shell
bin/kafka-server-start.sh -daemon config/server.properties
```

## 创建topic

```shell
bin/kafka-topics.sh --create --zookeeper 120.48.0.127:2181,192.144.237.32:2181,121.36.20.59:2181 --replication-factor 3 --partitions 7 --topic test
```

## 查看topic详情

```shell
bin/kafka-topics.sh --describe --zookeeper 120.48.0.127:2181,192.144.237.32:2181,121.36.20.59:2181 --topic test
```

## 启动生产者

```shell
bin/kafka-console-producer.sh --broker-list 120.48.0.127:9092,192.144.237.32:9092,121.36.20.59:9092 --topic test
```

## 启动消费者

```shell
bin/kafka-console-consumer.sh --bootstrap-server 120.48.0.127:9092,192.144.237.32:9092,121.36.20.59:9092 --topic test --from-beginning
```

## 删除topic

```shell
bin/kafka-topics.sh --zookeeper 120.48.0.127:2181,192.144.237.32:2181,121.36.20.59:2181 --delete --topic test
```

- [如何彻底删除topic](https://cloud.tencent.com/developer/article/1130824)

## 停止kafka

```shell
bin/kafka-server-stop.sh
```

# ES命令

## 运行

```shell
./bin/elasticsearch -d
```

## 加权限

```shell
sudo  chown -R bailingnan:bailingnan /home/bailingnan/elasticsearch-7.12.0
sudo  chown -R bailingnan:bailingnan /tmp/elasticsearch
```

## 判断是否可用

```shell
http://120.48.0.127:9200/_cat/health?v
```