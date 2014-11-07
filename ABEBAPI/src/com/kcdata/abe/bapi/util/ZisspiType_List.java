package com.kcdata.abe.bapi.util;
public class ZisspiType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -461013118L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZISSPI", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.ZisspiType.class, new com.kcdata.abe.bapi.ZisspiType(), new java.lang.String[][]{}, 230, 446, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZISSPI\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Passenger Table ( Item Level )</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>230</ifr:internalLength1><ifr:internalLength2>446</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  ZisspiType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.ZisspiType setZisspiType(int index, com.kcdata.abe.bapi.ZisspiType item) {
        return (com.kcdata.abe.bapi.ZisspiType)baseList().set(index, item);
    }

    public void addZisspiType(int index, com.kcdata.abe.bapi.ZisspiType item) {
        baseList().add(index, item);
    }

    public void addAllZisspiType(ZisspiType_List item) {
        baseList().addAll(item);
    }

    public boolean removeZisspiType(com.kcdata.abe.bapi.ZisspiType item) {
        return baseList().remove(item);
    }

    public boolean containsAllZisspiType(ZisspiType_List item) {
        return baseList().containsAll(item);
    }

    public void addZisspiType(com.kcdata.abe.bapi.ZisspiType item) {
        baseList().add(item);
    }

    public void addAllZisspiType(int index, ZisspiType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsZisspiType(com.kcdata.abe.bapi.ZisspiType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.ZisspiType getZisspiType(int index) {
        return (com.kcdata.abe.bapi.ZisspiType)baseList().get(index);
    }

    public int lastIndexOfZisspiType(com.kcdata.abe.bapi.ZisspiType item) {
        return baseList().lastIndexOf(item);
    }

    public ZisspiType_List subListZisspiType(int fromIndex, int toIndex) {
        return (ZisspiType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.ZisspiType[] toArrayZisspiType() {
        return (com.kcdata.abe.bapi.ZisspiType[])baseList().toArray(new com.kcdata.abe.bapi.ZisspiType[] {});
    }

    public com.kcdata.abe.bapi.ZisspiType removeZisspiType(int index) {
        return (com.kcdata.abe.bapi.ZisspiType)baseList().remove(index);
    }

    public int indexOfZisspiType(com.kcdata.abe.bapi.ZisspiType item) {
        return baseList().indexOf(item);
    }

}
