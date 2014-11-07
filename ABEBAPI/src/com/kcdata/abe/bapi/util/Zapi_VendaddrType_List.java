package com.kcdata.abe.bapi.util;
public class Zapi_VendaddrType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 941162735L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_VENDADDR", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_VendaddrType.class, new com.kcdata.abe.bapi.Zapi_VendaddrType(), new java.lang.String[][]{}, 399, 798, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_VENDADDR\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">vender address</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>399</ifr:internalLength1><ifr:internalLength2>798</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_VendaddrType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zapi_VendaddrType removeZapi_VendaddrType(int index) {
        return (com.kcdata.abe.bapi.Zapi_VendaddrType)baseList().remove(index);
    }

    public int lastIndexOfZapi_VendaddrType(com.kcdata.abe.bapi.Zapi_VendaddrType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Zapi_VendaddrType[] toArrayZapi_VendaddrType() {
        return (com.kcdata.abe.bapi.Zapi_VendaddrType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_VendaddrType[] {});
    }

    public Zapi_VendaddrType_List subListZapi_VendaddrType(int fromIndex, int toIndex) {
        return (Zapi_VendaddrType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Zapi_VendaddrType getZapi_VendaddrType(int index) {
        return (com.kcdata.abe.bapi.Zapi_VendaddrType)baseList().get(index);
    }

    public int indexOfZapi_VendaddrType(com.kcdata.abe.bapi.Zapi_VendaddrType item) {
        return baseList().indexOf(item);
    }

    public boolean removeZapi_VendaddrType(com.kcdata.abe.bapi.Zapi_VendaddrType item) {
        return baseList().remove(item);
    }

    public void addZapi_VendaddrType(com.kcdata.abe.bapi.Zapi_VendaddrType item) {
        baseList().add(item);
    }

    public void addAllZapi_VendaddrType(int index, Zapi_VendaddrType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsZapi_VendaddrType(com.kcdata.abe.bapi.Zapi_VendaddrType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zapi_VendaddrType setZapi_VendaddrType(int index, com.kcdata.abe.bapi.Zapi_VendaddrType item) {
        return (com.kcdata.abe.bapi.Zapi_VendaddrType)baseList().set(index, item);
    }

    public void addZapi_VendaddrType(int index, com.kcdata.abe.bapi.Zapi_VendaddrType item) {
        baseList().add(index, item);
    }

    public void addAllZapi_VendaddrType(Zapi_VendaddrType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllZapi_VendaddrType(Zapi_VendaddrType_List item) {
        return baseList().containsAll(item);
    }

}
