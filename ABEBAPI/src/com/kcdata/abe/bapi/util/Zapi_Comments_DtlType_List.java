package com.kcdata.abe.bapi.util;
public class Zapi_Comments_DtlType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 690935498L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_COMMENTS_DTL", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Comments_DtlType.class, new com.kcdata.abe.bapi.Zapi_Comments_DtlType(), new java.lang.String[][]{}, 205, 410, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_COMMENTS_DTL\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Comments of the Order detail</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>205</ifr:internalLength1><ifr:internalLength2>410</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Comments_DtlType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addAllZapi_Comments_DtlType(int index, Zapi_Comments_DtlType_List item) {
        baseList().addAll(index, item);
    }

    public int lastIndexOfZapi_Comments_DtlType(com.kcdata.abe.bapi.Zapi_Comments_DtlType item) {
        return baseList().lastIndexOf(item);
    }

    public boolean containsAllZapi_Comments_DtlType(Zapi_Comments_DtlType_List item) {
        return baseList().containsAll(item);
    }

    public void addAllZapi_Comments_DtlType(Zapi_Comments_DtlType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_Comments_DtlType getZapi_Comments_DtlType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Comments_DtlType)baseList().get(index);
    }

    public int indexOfZapi_Comments_DtlType(com.kcdata.abe.bapi.Zapi_Comments_DtlType item) {
        return baseList().indexOf(item);
    }

    public void addZapi_Comments_DtlType(com.kcdata.abe.bapi.Zapi_Comments_DtlType item) {
        baseList().add(item);
    }

    public boolean removeZapi_Comments_DtlType(com.kcdata.abe.bapi.Zapi_Comments_DtlType item) {
        return baseList().remove(item);
    }

    public boolean containsZapi_Comments_DtlType(com.kcdata.abe.bapi.Zapi_Comments_DtlType item) {
        return baseList().contains(item);
    }

    public Zapi_Comments_DtlType_List subListZapi_Comments_DtlType(int fromIndex, int toIndex) {
        return (Zapi_Comments_DtlType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Zapi_Comments_DtlType removeZapi_Comments_DtlType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Comments_DtlType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Zapi_Comments_DtlType setZapi_Comments_DtlType(int index, com.kcdata.abe.bapi.Zapi_Comments_DtlType item) {
        return (com.kcdata.abe.bapi.Zapi_Comments_DtlType)baseList().set(index, item);
    }

    public void addZapi_Comments_DtlType(int index, com.kcdata.abe.bapi.Zapi_Comments_DtlType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Comments_DtlType[] toArrayZapi_Comments_DtlType() {
        return (com.kcdata.abe.bapi.Zapi_Comments_DtlType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Comments_DtlType[] {});
    }

}
