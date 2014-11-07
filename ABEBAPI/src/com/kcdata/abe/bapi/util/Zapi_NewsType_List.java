package com.kcdata.abe.bapi.util;
public class Zapi_NewsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1995509420L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_NEWS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_NewsType.class, new com.kcdata.abe.bapi.Zapi_NewsType(), new java.lang.String[][]{}, 282, 564, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_NEWS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for storing News Info</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>282</ifr:internalLength1><ifr:internalLength2>564</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_NewsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int indexOfZapi_NewsType(com.kcdata.abe.bapi.Zapi_NewsType item) {
        return baseList().indexOf(item);
    }

    public Zapi_NewsType_List subListZapi_NewsType(int fromIndex, int toIndex) {
        return (Zapi_NewsType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean removeZapi_NewsType(com.kcdata.abe.bapi.Zapi_NewsType item) {
        return baseList().remove(item);
    }

    public int lastIndexOfZapi_NewsType(com.kcdata.abe.bapi.Zapi_NewsType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Zapi_NewsType setZapi_NewsType(int index, com.kcdata.abe.bapi.Zapi_NewsType item) {
        return (com.kcdata.abe.bapi.Zapi_NewsType)baseList().set(index, item);
    }

    public void addZapi_NewsType(com.kcdata.abe.bapi.Zapi_NewsType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Zapi_NewsType[] toArrayZapi_NewsType() {
        return (com.kcdata.abe.bapi.Zapi_NewsType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_NewsType[] {});
    }

    public void addAllZapi_NewsType(int index, Zapi_NewsType_List item) {
        baseList().addAll(index, item);
    }

    public void addZapi_NewsType(int index, com.kcdata.abe.bapi.Zapi_NewsType item) {
        baseList().add(index, item);
    }

    public void addAllZapi_NewsType(Zapi_NewsType_List item) {
        baseList().addAll(item);
    }

    public boolean containsZapi_NewsType(com.kcdata.abe.bapi.Zapi_NewsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zapi_NewsType removeZapi_NewsType(int index) {
        return (com.kcdata.abe.bapi.Zapi_NewsType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Zapi_NewsType getZapi_NewsType(int index) {
        return (com.kcdata.abe.bapi.Zapi_NewsType)baseList().get(index);
    }

    public boolean containsAllZapi_NewsType(Zapi_NewsType_List item) {
        return baseList().containsAll(item);
    }

}
