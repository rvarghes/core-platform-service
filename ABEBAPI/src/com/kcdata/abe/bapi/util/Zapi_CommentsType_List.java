package com.kcdata.abe.bapi.util;
public class Zapi_CommentsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -2066361907L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_COMMENTS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_CommentsType.class, new com.kcdata.abe.bapi.Zapi_CommentsType(), new java.lang.String[][]{}, 38, 74, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_COMMENTS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Comments of the Order</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>38</ifr:internalLength1><ifr:internalLength2>74</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_CommentsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zapi_CommentsType[] toArrayZapi_CommentsType() {
        return (com.kcdata.abe.bapi.Zapi_CommentsType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_CommentsType[] {});
    }

    public void addAllZapi_CommentsType(Zapi_CommentsType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_CommentsType getZapi_CommentsType(int index) {
        return (com.kcdata.abe.bapi.Zapi_CommentsType)baseList().get(index);
    }

    public int indexOfZapi_CommentsType(com.kcdata.abe.bapi.Zapi_CommentsType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zapi_CommentsType removeZapi_CommentsType(int index) {
        return (com.kcdata.abe.bapi.Zapi_CommentsType)baseList().remove(index);
    }

    public void addAllZapi_CommentsType(int index, Zapi_CommentsType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsAllZapi_CommentsType(Zapi_CommentsType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_CommentsType setZapi_CommentsType(int index, com.kcdata.abe.bapi.Zapi_CommentsType item) {
        return (com.kcdata.abe.bapi.Zapi_CommentsType)baseList().set(index, item);
    }

    public void addZapi_CommentsType(int index, com.kcdata.abe.bapi.Zapi_CommentsType item) {
        baseList().add(index, item);
    }

    public boolean containsZapi_CommentsType(com.kcdata.abe.bapi.Zapi_CommentsType item) {
        return baseList().contains(item);
    }

    public boolean removeZapi_CommentsType(com.kcdata.abe.bapi.Zapi_CommentsType item) {
        return baseList().remove(item);
    }

    public Zapi_CommentsType_List subListZapi_CommentsType(int fromIndex, int toIndex) {
        return (Zapi_CommentsType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addZapi_CommentsType(com.kcdata.abe.bapi.Zapi_CommentsType item) {
        baseList().add(item);
    }

    public int lastIndexOfZapi_CommentsType(com.kcdata.abe.bapi.Zapi_CommentsType item) {
        return baseList().lastIndexOf(item);
    }

}
