package com.kcdata.abe.bapi.util;
public class Zapi_Commission_DtlsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1689469050L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_COMMISSION_DTLS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Commission_DtlsType.class, new com.kcdata.abe.bapi.Zapi_Commission_DtlsType(), new java.lang.String[][]{}, 80, 144, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_COMMISSION_DTLS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Commission Details</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>80</ifr:internalLength1><ifr:internalLength2>144</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Commission_DtlsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zapi_Commission_DtlsType[] toArrayZapi_Commission_DtlsType() {
        return (com.kcdata.abe.bapi.Zapi_Commission_DtlsType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Commission_DtlsType[] {});
    }

    public void addAllZapi_Commission_DtlsType(Zapi_Commission_DtlsType_List item) {
        baseList().addAll(item);
    }

    public void addZapi_Commission_DtlsType(int index, com.kcdata.abe.bapi.Zapi_Commission_DtlsType item) {
        baseList().add(index, item);
    }

    public Zapi_Commission_DtlsType_List subListZapi_Commission_DtlsType(int fromIndex, int toIndex) {
        return (Zapi_Commission_DtlsType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Zapi_Commission_DtlsType getZapi_Commission_DtlsType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Commission_DtlsType)baseList().get(index);
    }

    public boolean containsAllZapi_Commission_DtlsType(Zapi_Commission_DtlsType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_Commission_DtlsType setZapi_Commission_DtlsType(int index, com.kcdata.abe.bapi.Zapi_Commission_DtlsType item) {
        return (com.kcdata.abe.bapi.Zapi_Commission_DtlsType)baseList().set(index, item);
    }

    public void addZapi_Commission_DtlsType(com.kcdata.abe.bapi.Zapi_Commission_DtlsType item) {
        baseList().add(item);
    }

    public int indexOfZapi_Commission_DtlsType(com.kcdata.abe.bapi.Zapi_Commission_DtlsType item) {
        return baseList().indexOf(item);
    }

    public boolean containsZapi_Commission_DtlsType(com.kcdata.abe.bapi.Zapi_Commission_DtlsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zapi_Commission_DtlsType removeZapi_Commission_DtlsType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Commission_DtlsType)baseList().remove(index);
    }

    public int lastIndexOfZapi_Commission_DtlsType(com.kcdata.abe.bapi.Zapi_Commission_DtlsType item) {
        return baseList().lastIndexOf(item);
    }

    public boolean removeZapi_Commission_DtlsType(com.kcdata.abe.bapi.Zapi_Commission_DtlsType item) {
        return baseList().remove(item);
    }

    public void addAllZapi_Commission_DtlsType(int index, Zapi_Commission_DtlsType_List item) {
        baseList().addAll(index, item);
    }

}
