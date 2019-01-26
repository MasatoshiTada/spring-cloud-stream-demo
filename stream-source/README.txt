■TODO 09 RabbitMQ管理コンソール
RabbitMQを起動後、ブラウザで http://localhost:15672/ にアクセスする
(ユーザー名:guest、パスワード:guest)

■TODO 10 通常通り起動
コマンドプロンプトを3つ開く。
1つ目
stream-source> mvn clean package
stream-source> java -jar target/stream-source-0.0.1-SNAPSHOT.jar

2つ目
stream-sink> mvn clean package
stream-sink> java -jar target/stream-sink-0.0.1-SNAPSHOT.jar

3つ目
stream-sink> java -jar target/stream-sink-0.0.1-SNAPSHOT.jar --server.port=8091

- 2つのsink両方にメッセージが表示される
- RabbitMQ管理コンソールを確認すると、[Exchange]に[greeting]、[Queue]に[greeting.anonymous.xxxxx]が作成されている
- 2つのsinkをいったん終了後(sourceはそのまま)に再起動すると、終了中にキューに溜まっていたメッセージを一気に受けとる

■TODO 11 Consumer Groupの設定
stream-sinkのapplication.propertiesに下記のプロパティを追加
spring.cloud.stream.bindings.input.group=group1

1つ目
stream-source> mvn clean package
stream-source> java -jar target/stream-source-0.0.1-SNAPSHOT.jar

2つ目
stream-sink> mvn clean package
stream-sink> java -jar target/stream-sink-0.0.1-SNAPSHOT.jar

3つ目
stream-sink> java -jar target/stream-sink-0.0.1-SNAPSHOT.jar --server.port=8091

- 1つのメッセージは1つのsink両方にしか表示されない
- RabbitMQ管理コンソールを確認すると、[Exchange]に[greeting]、[Queue]に[greeting.group1]が作成されている

■TODO 12 Partitioningの設定
stream-sourceのapplication.propertiesに下記のプロパティを追加
spring.cloud.stream.bindings.output.producer.partitionKeyExpression=payload.id % 2
spring.cloud.stream.bindings.output.producer.partitionCount=2

stream-sinkのapplication.propertiesに下記のプロパティを追加
spring.cloud.stream.bindings.input.consumer.partitioned=true
spring.cloud.stream.instanceIndex=0
spring.cloud.stream.instanceCount=2

1つ目
stream-source> mvn clean package
stream-source> java -jar target/stream-source-0.0.1-SNAPSHOT.jar

2つ目
stream-sink> mvn clean package
stream-sink> java -jar target/stream-sink-0.0.1-SNAPSHOT.jar

3つ目
stream-sink> java -jar target/stream-sink-0.0.1-SNAPSHOT.jar --server.port=8091 --spring.cloud.stream.instanceIndex=1

- id値の偶数/奇数でメッセージが特定のインスタンスに振り分けられる
- RabbitMQ管理コンソールを確認すると、[Exchange]に[greeting]、[Queue]に[greeting.group1-0]・[greeting.group1-1]が作成されている
