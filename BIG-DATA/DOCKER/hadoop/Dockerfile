FROM openjdk:11-bullseye

ARG HADOOP_VERSION=3.4.0
WORKDIR /hadoop

RUN apt update \
    && apt install wget vim -y \
    && apt-get clean

RUN wget "https://dlcdn.apache.org/hadoop/common/hadoop-$HADOOP_VERSION/hadoop-$HADOOP_VERSION.tar.gz"
RUN tar -xzf "hadoop-$HADOOP_VERSION.tar.gz"
RUN mv hadoop-$HADOOP_VERSION/* .
RUN rm "hadoop-$HADOOP_VERSION.tar.gz"
RUN rm -R "hadoop-$HADOOP_VERSION"

RUN mkdir -p /tmp/hadoop-root/dfs/name

ENV HADOOP_HOME /hadoop
ENV HADOOP_INSTALL $HADOOP_HOME
ENV HADOOP_MAPRED_HOME $HADOOP_HOME
ENV HADOOP_COMMON_HOME $HADOOP_HOME
ENV HADOOP_HDFS_HOME $HADOOP_HOME
ENV HADOOP_YARN_HOME $HADOOP_HOME
ENV HADOOP_COMMON_LIB_NATIVE_DIR $HADOOP_HOME/lib/native
ENV PATH $PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin
ENV HADOOP_OPTS "-Djava.library.path=$HADOOP_HOME/lib/native"

COPY core-site.xml etc/hadoop/core-site.xml
COPY hdfs-site.xml etc/hadoop/hdfs-site.xml

CMD [ "bash" ]
