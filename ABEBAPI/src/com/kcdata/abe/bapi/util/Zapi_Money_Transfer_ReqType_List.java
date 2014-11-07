package com.kcdata.abe.bapi.util;
public class Zapi_Money_Transfer_ReqType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 2107731458L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_MONEY_TRANSFER_REQ", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType.class, new com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType(), new java.lang.String[][]{}, 58, 108, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_MONEY_TRANSFER_REQ\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Money Transfer Request</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>58</ifr:internalLength1><ifr:internalLength2>108</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Money_Transfer_ReqType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addAllZapi_Money_Transfer_ReqType(Zapi_Money_Transfer_ReqType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType setZapi_Money_Transfer_ReqType(int index, com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType item) {
        return (com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType)baseList().set(index, item);
    }

    public int indexOfZapi_Money_Transfer_ReqType(com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType getZapi_Money_Transfer_ReqType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType)baseList().get(index);
    }

    public int lastIndexOfZapi_Money_Transfer_ReqType(com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType item) {
        return baseList().lastIndexOf(item);
    }

    public void addZapi_Money_Transfer_ReqType(int index, com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType item) {
        baseList().add(index, item);
    }

    public boolean containsZapi_Money_Transfer_ReqType(com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType item) {
        return baseList().contains(item);
    }

    public boolean removeZapi_Money_Transfer_ReqType(com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType[] toArrayZapi_Money_Transfer_ReqType() {
        return (com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType[] {});
    }

    public com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType removeZapi_Money_Transfer_ReqType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType)baseList().remove(index);
    }

    public Zapi_Money_Transfer_ReqType_List subListZapi_Money_Transfer_ReqType(int fromIndex, int toIndex) {
        return (Zapi_Money_Transfer_ReqType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllZapi_Money_Transfer_ReqType(int index, Zapi_Money_Transfer_ReqType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsAllZapi_Money_Transfer_ReqType(Zapi_Money_Transfer_ReqType_List item) {
        return baseList().containsAll(item);
    }

    public void addZapi_Money_Transfer_ReqType(com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType item) {
        baseList().add(item);
    }

}
