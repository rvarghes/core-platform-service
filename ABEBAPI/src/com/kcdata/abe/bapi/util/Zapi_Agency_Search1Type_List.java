package com.kcdata.abe.bapi.util;
public class Zapi_Agency_Search1Type_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 220698696L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_AGENCY_SEARCH1", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Agency_Search1Type.class, new com.kcdata.abe.bapi.Zapi_Agency_Search1Type(), new java.lang.String[][]{}, 119, 238, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_AGENCY_SEARCH1\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Agency Search Info</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>119</ifr:internalLength1><ifr:internalLength2>238</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Agency_Search1Type_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zapi_Agency_Search1Type getZapi_Agency_Search1Type(int index) {
        return (com.kcdata.abe.bapi.Zapi_Agency_Search1Type)baseList().get(index);
    }

    public int indexOfZapi_Agency_Search1Type(com.kcdata.abe.bapi.Zapi_Agency_Search1Type item) {
        return baseList().indexOf(item);
    }

    public void addAllZapi_Agency_Search1Type(Zapi_Agency_Search1Type_List item) {
        baseList().addAll(item);
    }

    public boolean containsZapi_Agency_Search1Type(com.kcdata.abe.bapi.Zapi_Agency_Search1Type item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zapi_Agency_Search1Type[] toArrayZapi_Agency_Search1Type() {
        return (com.kcdata.abe.bapi.Zapi_Agency_Search1Type[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Agency_Search1Type[] {});
    }

    public com.kcdata.abe.bapi.Zapi_Agency_Search1Type removeZapi_Agency_Search1Type(int index) {
        return (com.kcdata.abe.bapi.Zapi_Agency_Search1Type)baseList().remove(index);
    }

    public int lastIndexOfZapi_Agency_Search1Type(com.kcdata.abe.bapi.Zapi_Agency_Search1Type item) {
        return baseList().lastIndexOf(item);
    }

    public boolean removeZapi_Agency_Search1Type(com.kcdata.abe.bapi.Zapi_Agency_Search1Type item) {
        return baseList().remove(item);
    }

    public void addZapi_Agency_Search1Type(com.kcdata.abe.bapi.Zapi_Agency_Search1Type item) {
        baseList().add(item);
    }

    public void addAllZapi_Agency_Search1Type(int index, Zapi_Agency_Search1Type_List item) {
        baseList().addAll(index, item);
    }

    public Zapi_Agency_Search1Type_List subListZapi_Agency_Search1Type(int fromIndex, int toIndex) {
        return (Zapi_Agency_Search1Type_List)baseList().subList(fromIndex, toIndex);
    }

    public void addZapi_Agency_Search1Type(int index, com.kcdata.abe.bapi.Zapi_Agency_Search1Type item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Agency_Search1Type setZapi_Agency_Search1Type(int index, com.kcdata.abe.bapi.Zapi_Agency_Search1Type item) {
        return (com.kcdata.abe.bapi.Zapi_Agency_Search1Type)baseList().set(index, item);
    }

    public boolean containsAllZapi_Agency_Search1Type(Zapi_Agency_Search1Type_List item) {
        return baseList().containsAll(item);
    }

}
