package com.kcdata.abe.bapi.util;
public class Zapi_Credit_CardType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 657594929L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_CREDIT_CARD", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Credit_CardType.class, new com.kcdata.abe.bapi.Zapi_Credit_CardType(), new java.lang.String[][]{}, 310, 608, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_CREDIT_CARD\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Credit Card Payment</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>310</ifr:internalLength1><ifr:internalLength2>608</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Credit_CardType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsZapi_Credit_CardType(com.kcdata.abe.bapi.Zapi_Credit_CardType item) {
        return baseList().contains(item);
    }

    public int lastIndexOfZapi_Credit_CardType(com.kcdata.abe.bapi.Zapi_Credit_CardType item) {
        return baseList().lastIndexOf(item);
    }

    public boolean containsAllZapi_Credit_CardType(Zapi_Credit_CardType_List item) {
        return baseList().containsAll(item);
    }

    public void addAllZapi_Credit_CardType(Zapi_Credit_CardType_List item) {
        baseList().addAll(item);
    }

    public int indexOfZapi_Credit_CardType(com.kcdata.abe.bapi.Zapi_Credit_CardType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zapi_Credit_CardType[] toArrayZapi_Credit_CardType() {
        return (com.kcdata.abe.bapi.Zapi_Credit_CardType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Credit_CardType[] {});
    }

    public void addAllZapi_Credit_CardType(int index, Zapi_Credit_CardType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Credit_CardType removeZapi_Credit_CardType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Credit_CardType)baseList().remove(index);
    }

    public Zapi_Credit_CardType_List subListZapi_Credit_CardType(int fromIndex, int toIndex) {
        return (Zapi_Credit_CardType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Zapi_Credit_CardType getZapi_Credit_CardType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Credit_CardType)baseList().get(index);
    }

    public void addZapi_Credit_CardType(com.kcdata.abe.bapi.Zapi_Credit_CardType item) {
        baseList().add(item);
    }

    public boolean removeZapi_Credit_CardType(com.kcdata.abe.bapi.Zapi_Credit_CardType item) {
        return baseList().remove(item);
    }

    public void addZapi_Credit_CardType(int index, com.kcdata.abe.bapi.Zapi_Credit_CardType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Credit_CardType setZapi_Credit_CardType(int index, com.kcdata.abe.bapi.Zapi_Credit_CardType item) {
        return (com.kcdata.abe.bapi.Zapi_Credit_CardType)baseList().set(index, item);
    }

}
