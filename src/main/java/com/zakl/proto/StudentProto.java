// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Srudent.proto

package com.zakl.proto;

public final class StudentProto {
  private StudentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_zakl_protobuf_MyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_zakl_protobuf_MyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_zakl_protobuf_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_zakl_protobuf_MyResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_zakl_protobuf_StudentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_zakl_protobuf_StudentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_zakl_protobuf_StudentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_zakl_protobuf_StudentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_zakl_protobuf_StudentResponseList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_zakl_protobuf_StudentResponseList_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rSrudent.proto\022\021com.zakl.protobuf\"\035\n\tMy" +
      "Request\022\020\n\010username\030\001 \001(\t\"\036\n\nMyResponse\022" +
      "\020\n\010realname\030\002 \001(\t\"\035\n\016StudentRequest\022\013\n\003a" +
      "ge\030\001 \001(\005\":\n\017StudentResponse\022\014\n\004name\030\001 \001(" +
      "\t\022\013\n\003age\030\002 \001(\t\022\014\n\004city\030\003 \001(\t\"R\n\023StudentR" +
      "esponseList\022;\n\017studentResponse\030\001 \003(\0132\".c" +
      "om.zakl.protobuf.StudentResponse2\232\003\n\016Stu" +
      "dentService\022V\n\025GetRealNameByUserName\022\034.c" +
      "om.zakl.protobuf.MyRequest\032\035.com.zakl.pr" +
      "otobuf.MyResponse\"\000\022]\n\020GetStudentsBuAge\022" +
      "!.com.zakl.protobuf.StudentRequest\032\".com" +
      ".zakl.protobuf.StudentResponse\"\0000\001\022h\n\027Ge" +
      "tStudentWrapperByAges\022!.com.zakl.protobu" +
      "f.StudentRequest\032&.com.zakl.protobuf.Stu" +
      "dentResponseList\"\000(\001\022g\n\030GetStudentWrappe" +
      "rByAges2\022!.com.zakl.protobuf.StudentRequ" +
      "est\032\".com.zakl.protobuf.StudentResponse\"" +
      "\000(\0010\001B\"\n\016com.zakl.protoB\014StudentProtoH\001P" +
      "\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_zakl_protobuf_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_zakl_protobuf_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_zakl_protobuf_MyRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_com_zakl_protobuf_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_zakl_protobuf_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_zakl_protobuf_MyResponse_descriptor,
        new java.lang.String[] { "Realname", });
    internal_static_com_zakl_protobuf_StudentRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_zakl_protobuf_StudentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_zakl_protobuf_StudentRequest_descriptor,
        new java.lang.String[] { "Age", });
    internal_static_com_zakl_protobuf_StudentResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_zakl_protobuf_StudentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_zakl_protobuf_StudentResponse_descriptor,
        new java.lang.String[] { "Name", "Age", "City", });
    internal_static_com_zakl_protobuf_StudentResponseList_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_zakl_protobuf_StudentResponseList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_zakl_protobuf_StudentResponseList_descriptor,
        new java.lang.String[] { "StudentResponse", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
