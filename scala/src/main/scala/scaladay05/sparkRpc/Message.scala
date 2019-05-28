package scaladay05.sparkRpc

class Message {

}

//worker向maser发送注册信息
case class RegisterWorkerInfo(id:String,core:Int,ram:Int)

//worker向master发送心跳信息
case class HeartBeart(id:String)

//master 向worker发送注册成功的消息
case object RegisteredWorkerInfo

//worker 自己发送给自己一条消息（心跳信息）
case object SendHeartBeat

//master 检查是否有worker过时（长时间不发送心跳）
case object CheckTimeOutWorker

//master 清理过时的worker
case object RemoveTimeOutWorker

//存储work的基本信息
class workInfo(id:String,core:Int,ram:Int){
  //上次的心跳发送时间
  var lastHeartBeatTime:Long = _
}
