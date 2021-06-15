Infinispan with RocksDB cache store
==============================

### Build

```shell script
mvn clean package
```      

### Run

```shell script
java -Djgroups.bind.address=127.0.0.1 -jar infinispan-rocksdb-1.0-SNAPSHOT-runner.jar 
```         

### How to produce an exception "MarshallableUserObject marshaller not overridden in SerializationContext"
     
Start the first node
```shell script
java -Djgroups.bind.address=127.0.0.1 -Dquarkus.http.port=8100 -Ddata.dir=data1 -jar infinispan-rocksdb-1.0-SNAPSHOT-runner.jar 
```
Then fill up caches
```shell script
ab -n 2000000 -c 20 -k -m put http://localhost:8100/test
ab -n 500000 -c 20 -k -m put http://localhost:8100/indexed
```
After that, start the second node
```shell script
java -Djgroups.bind.address=127.0.0.1 -Dquarkus.http.port=8101 -Ddata.dir=data2 -jar infinispan-rocksdb-1.0-SNAPSHOT-runner.jar 
```
And, the second node gets an exception with that stack trace
```java
ISPN000474: Error processing request 11@iamundef-58489: java.lang.IllegalStateException: MarshallableUserObject marshaller not overridden in SerializationContext
        at org.infinispan.marshall.protostream.impl.MarshallableUserObject.<init>(MarshallableUserObject.java:44)
        at org.infinispan.marshall.protostream.impl.MarshallableUserObject$___Marshaller_ff6b068168b51aac5d0c18c371e02ff55d3bb0cb73296e9cf1f4a65917105dec.read(MarshallableUserObject$___Marshaller_ff6b068168b51aac5d0c18c371e02ff55d3bb0cb73296e9cf1f4a65917105dec.java:49)
        at org.infinispan.marshall.protostream.impl.MarshallableUserObject$___Marshaller_ff6b068168b51aac5d0c18c371e02ff55d3bb0cb73296e9cf1f4a65917105dec.read(MarshallableUserObject$___Marshaller_ff6b068168b51aac5d0c18c371e02ff55d3bb0cb73296e9cf1f4a65917105dec.java:15)
        at org.infinispan.protostream.impl.ProtobufTagMarshallerDelegate.unmarshall(ProtobufTagMarshallerDelegate.java:32)
        at org.infinispan.protostream.WrappedMessage.readMessage(WrappedMessage.java:539)
        at org.infinispan.protostream.WrappedMessage.read(WrappedMessage.java:351)
        at org.infinispan.protostream.ProtobufUtil.fromWrappedByteArray(ProtobufUtil.java:129)
        at org.infinispan.marshall.protostream.impl.AbstractInternalProtoStreamMarshaller.objectFromByteBuffer(AbstractInternalProtoStreamMarshaller.java:97)
        at org.infinispan.marshall.protostream.impl.AbstractInternalProtoStreamMarshaller.objectFromByteBuffer(AbstractInternalProtoStreamMarshaller.java:92)
        at org.infinispan.marshall.core.GlobalMarshaller.readUnknown(GlobalMarshaller.java:905)
        at org.infinispan.marshall.core.GlobalMarshaller.readUnknown(GlobalMarshaller.java:890)
        at org.infinispan.marshall.core.GlobalMarshaller.readNonNullableObject(GlobalMarshaller.java:714)
        at org.infinispan.marshall.core.GlobalMarshaller.readNullableObject(GlobalMarshaller.java:357)
        at org.infinispan.marshall.core.BytesObjectInput.readObject(BytesObjectInput.java:32)
        at org.infinispan.container.entries.ImmortalCacheEntry$Externalizer.readObject(ImmortalCacheEntry.java:108)
        at org.infinispan.container.entries.ImmortalCacheEntry$Externalizer.readObject(ImmortalCacheEntry.java:97)
        at org.infinispan.marshall.core.GlobalMarshaller.readWithExternalizer(GlobalMarshaller.java:727)
        at org.infinispan.marshall.core.GlobalMarshaller.readNonNullableObject(GlobalMarshaller.java:708)
        at org.infinispan.marshall.core.GlobalMarshaller.readNullableObject(GlobalMarshaller.java:357)
        at org.infinispan.marshall.core.BytesObjectInput.readObject(BytesObjectInput.java:32)
        at org.infinispan.commons.marshall.MarshallUtil.lambda$unmarshallCollection$0(MarshallUtil.java:293)
        at org.infinispan.commons.marshall.MarshallUtil.unmarshallCollection(MarshallUtil.java:276)
        at org.infinispan.commons.marshall.MarshallUtil.unmarshallCollection(MarshallUtil.java:293)
        at org.infinispan.marshall.exts.CollectionExternalizer.readObject(CollectionExternalizer.java:103)
        at org.infinispan.marshall.exts.CollectionExternalizer.readObject(CollectionExternalizer.java:28)
        at org.infinispan.marshall.core.GlobalMarshaller.readWithExternalizer(GlobalMarshaller.java:727)
        at org.infinispan.marshall.core.GlobalMarshaller.readNonNullableObject(GlobalMarshaller.java:708)
        at org.infinispan.marshall.core.GlobalMarshaller.readNullableObject(GlobalMarshaller.java:357)
        at org.infinispan.marshall.core.BytesObjectInput.readObject(BytesObjectInput.java:32)
        at org.infinispan.statetransfer.StateChunk$Externalizer.readObject(StateChunk.java:88)
        at org.infinispan.statetransfer.StateChunk$Externalizer.readObject(StateChunk.java:65)
        at org.infinispan.marshall.core.GlobalMarshaller.readWithExternalizer(GlobalMarshaller.java:727)
        at org.infinispan.marshall.core.GlobalMarshaller.readNonNullableObject(GlobalMarshaller.java:708)
        at org.infinispan.marshall.core.GlobalMarshaller.readNullableObject(GlobalMarshaller.java:357)
        at org.infinispan.marshall.core.BytesObjectInput.readObject(BytesObjectInput.java:32)
        at org.infinispan.commons.marshall.MarshallUtil.lambda$unmarshallCollection$0(MarshallUtil.java:293)
        at org.infinispan.commons.marshall.MarshallUtil.unmarshallCollection(MarshallUtil.java:276)
        at org.infinispan.commons.marshall.MarshallUtil.unmarshallCollection(MarshallUtil.java:293)
        at org.infinispan.commands.statetransfer.StateResponseCommand.readFrom(StateResponseCommand.java:125)
        at org.infinispan.marshall.exts.ReplicableCommandExternalizer.readCommandParameters(ReplicableCommandExternalizer.java:117)
        at org.infinispan.marshall.exts.CacheRpcCommandExternalizer.readObject(CacheRpcCommandExternalizer.java:162)
        at org.infinispan.marshall.exts.CacheRpcCommandExternalizer.readObject(CacheRpcCommandExternalizer.java:85)
        at org.infinispan.marshall.core.GlobalMarshaller.readWithExternalizer(GlobalMarshaller.java:727)
        at org.infinispan.marshall.core.GlobalMarshaller.readNonNullableObject(GlobalMarshaller.java:708)
        at org.infinispan.marshall.core.GlobalMarshaller.readNullableObject(GlobalMarshaller.java:357)
        at org.infinispan.marshall.core.GlobalMarshaller.objectFromObjectInput(GlobalMarshaller.java:191)
        at org.infinispan.marshall.core.GlobalMarshaller.objectFromByteBuffer(GlobalMarshaller.java:220)
        at org.infinispan.remoting.transport.jgroups.JGroupsTransport.processRequest(JGroupsTransport.java:1374)
        at org.infinispan.remoting.transport.jgroups.JGroupsTransport.processMessage(JGroupsTransport.java:1314)
        at org.infinispan.remoting.transport.jgroups.JGroupsTransport.access$300(JGroupsTransport.java:133)
        at org.infinispan.remoting.transport.jgroups.JGroupsTransport$ChannelCallbacks.up(JGroupsTransport.java:1458)
        at org.jgroups.JChannel.up(JChannel.java:784)
        at org.jgroups.stack.ProtocolStack.up(ProtocolStack.java:913)
        at org.jgroups.protocols.FRAG3.up(FRAG3.java:160)
        at org.jgroups.protocols.FlowControl.up(FlowControl.java:355)
        at org.jgroups.protocols.FlowControl.up(FlowControl.java:363)
        at org.jgroups.protocols.pbcast.GMS.up(GMS.java:876)
        at org.jgroups.protocols.pbcast.STABLE.up(STABLE.java:254)
        at org.jgroups.protocols.UNICAST3.deliverMessage(UNICAST3.java:1048)
        at org.jgroups.protocols.UNICAST3.addMessage(UNICAST3.java:771)
        at org.jgroups.protocols.UNICAST3.handleDataReceived(UNICAST3.java:752)
        at org.jgroups.protocols.UNICAST3.up(UNICAST3.java:405)
        at org.jgroups.protocols.pbcast.NAKACK2.up(NAKACK2.java:592)
        at org.jgroups.protocols.VERIFY_SUSPECT.up(VERIFY_SUSPECT.java:132)
        at org.jgroups.protocols.FailureDetection.up(FailureDetection.java:186)
        at org.jgroups.protocols.FD_SOCK.up(FD_SOCK.java:254)
        at org.jgroups.protocols.MERGE3.up(MERGE3.java:281)
        at org.jgroups.protocols.Discovery.up(Discovery.java:300)
        at org.jgroups.protocols.TP.passMessageUp(TP.java:1400)
        at org.jgroups.util.SubmitToThreadPool$SingleMessageHandler.run(SubmitToThreadPool.java:98)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
        at java.base/java.lang.Thread.run(Thread.java:834)
```