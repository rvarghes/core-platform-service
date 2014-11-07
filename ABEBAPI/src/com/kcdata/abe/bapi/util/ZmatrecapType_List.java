package com.kcdata.abe.bapi.util;
public class ZmatrecapType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1607736467L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZMATRECAP", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.ZmatrecapType.class, new com.kcdata.abe.bapi.ZmatrecapType(), new java.lang.String[][]{}, 277, 554, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZMATRECAP\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Material Recap</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>277</ifr:internalLength1><ifr:internalLength2>554</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  ZmatrecapType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsZmatrecapType(com.kcdata.abe.bapi.ZmatrecapType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.ZmatrecapType setZmatrecapType(int index, com.kcdata.abe.bapi.ZmatrecapType item) {
        return (com.kcdata.abe.bapi.ZmatrecapType)baseList().set(index, item);
    }

    public void addZmatrecapType(int index, com.kcdata.abe.bapi.ZmatrecapType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.ZmatrecapType removeZmatrecapType(int index) {
        return (com.kcdata.abe.bapi.ZmatrecapType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.ZmatrecapType[] toArrayZmatrecapType() {
        return (com.kcdata.abe.bapi.ZmatrecapType[])baseList().toArray(new com.kcdata.abe.bapi.ZmatrecapType[] {});
    }

    public int lastIndexOfZmatrecapType(com.kcdata.abe.bapi.ZmatrecapType item) {
        return baseList().lastIndexOf(item);
    }

    public ZmatrecapType_List subListZmatrecapType(int fromIndex, int toIndex) {
        return (ZmatrecapType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllZmatrecapType(int index, ZmatrecapType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllZmatrecapType(ZmatrecapType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.ZmatrecapType getZmatrecapType(int index) {
        return (com.kcdata.abe.bapi.ZmatrecapType)baseList().get(index);
    }

    public boolean containsAllZmatrecapType(ZmatrecapType_List item) {
        return baseList().containsAll(item);
    }

    public int indexOfZmatrecapType(com.kcdata.abe.bapi.ZmatrecapType item) {
        return baseList().indexOf(item);
    }

    public boolean removeZmatrecapType(com.kcdata.abe.bapi.ZmatrecapType item) {
        return baseList().remove(item);
    }

    public void addZmatrecapType(com.kcdata.abe.bapi.ZmatrecapType item) {
        baseList().add(item);
    }

}
