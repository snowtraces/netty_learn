package org.xinyo.netty.example.sixth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int time = LocalDateTime.now().getSecond();
        MyDataInfo.MyMessage message;
        if ((time & 1) == 0) {
            message = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder()
                            .setName("张三")
                            .setAge(20)
                            .setAddress("上海")
                            .build())
                    .build();
        } else {
            message = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.StudentType)
                    .setStudent(MyDataInfo.Student.newBuilder()
                            .setName("李四")
                            .setAge(20)
                            .setGrade("3")
                            .build())
                    .build();
        }

        ctx.channel().writeAndFlush(message);
    }
}
