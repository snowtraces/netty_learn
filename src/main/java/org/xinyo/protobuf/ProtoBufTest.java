package org.xinyo.protobuf;

public class ProtoBufTest {
    public static void main(String[] args) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三")
                .setAge(20)
                .setAddress("上海")
                .build();
        byte[] studentByteArray = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(studentByteArray);
        System.out.println(student1);

    }
}
