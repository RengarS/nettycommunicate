# nettycommunicate

 netty群聊应用
 
 
 严重bug，最多只允许两人在线
 原因：netty的ByteBuf生命周期
 解决方法：ByteBuf拷贝
