package com.kcdata.abe.bapi.util;
public class Zapi_Tourop_Itn_PaytodateType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -718142776L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_TOUROP_ITN_PAYTODATE", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType.class, new com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType(), new java.lang.String[][]{}, 120, 234, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_TOUROP_ITN_PAYTODATE\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Itinerary Payments to Date</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>120</ifr:internalLength1><ifr:internalLength2>234</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Tourop_Itn_PaytodateType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType getZapi_Tourop_Itn_PaytodateType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType setZapi_Tourop_Itn_PaytodateType(int index, com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType item) {
        return (com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType)baseList().set(index, item);
    }

    public Zapi_Tourop_Itn_PaytodateType_List subListZapi_Tourop_Itn_PaytodateType(int fromIndex, int toIndex) {
        return (Zapi_Tourop_Itn_PaytodateType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addZapi_Tourop_Itn_PaytodateType(com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType removeZapi_Tourop_Itn_PaytodateType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType[] toArrayZapi_Tourop_Itn_PaytodateType() {
        return (com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType[] {});
    }

    public boolean removeZapi_Tourop_Itn_PaytodateType(com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType item) {
        return baseList().remove(item);
    }

    public void addAllZapi_Tourop_Itn_PaytodateType(Zapi_Tourop_Itn_PaytodateType_List item) {
        baseList().addAll(item);
    }

    public void addZapi_Tourop_Itn_PaytodateType(int index, com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType item) {
        baseList().add(index, item);
    }

    public boolean containsZapi_Tourop_Itn_PaytodateType(com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType item) {
        return baseList().contains(item);
    }

    public boolean containsAllZapi_Tourop_Itn_PaytodateType(Zapi_Tourop_Itn_PaytodateType_List item) {
        return baseList().containsAll(item);
    }

    public void addAllZapi_Tourop_Itn_PaytodateType(int index, Zapi_Tourop_Itn_PaytodateType_List item) {
        baseList().addAll(index, item);
    }

    public int indexOfZapi_Tourop_Itn_PaytodateType(com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType item) {
        return baseList().indexOf(item);
    }

    public int lastIndexOfZapi_Tourop_Itn_PaytodateType(com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType item) {
        return baseList().lastIndexOf(item);
    }

}
