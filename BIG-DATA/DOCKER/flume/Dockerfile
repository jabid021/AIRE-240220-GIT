FROM hadoop

ARG FLUME_VERSION=1.11.0

WORKDIR /flume

RUN wget "https://dlcdn.apache.org/flume/$FLUME_VERSION/apache-flume-$FLUME_VERSION-bin.tar.gz"
RUN tar -xzf "apache-flume-$FLUME_VERSION-bin.tar.gz"
RUN mv apache-flume-$FLUME_VERSION-bin/* .
RUN rm "apache-flume-$FLUME_VERSION-bin.tar.gz"
RUN rm -R "apache-flume-$FLUME_VERSION-bin"

ENV FLUME_HOME /flume
ENV PATH $PATH:$FLUME_HOME/bin

COPY spooldir.conf .

CMD [ "bash" ]
