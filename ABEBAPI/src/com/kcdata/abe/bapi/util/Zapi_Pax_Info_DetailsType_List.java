package com.kcdata.abe.bapi.util;
public class Zapi_Pax_Info_DetailsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -978489694L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_PAX_INFO_DETAILS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType.class, new com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType(), new java.lang.String[][]{}, 659, 1262, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_PAX_INFO_DETAILS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Passenger Info Header prices</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>659</ifr:internalLength1><ifr:internalLength2>1262</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Pax_Info_DetailsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType getZapi_Pax_Info_DetailsType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType)baseList().get(index);
    }

    public int lastIndexOfZapi_Pax_Info_DetailsType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType item) {
        return baseList().lastIndexOf(item);
    }

    public void addAllZapi_Pax_Info_DetailsType(int index, Zapi_Pax_Info_DetailsType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllZapi_Pax_Info_DetailsType(Zapi_Pax_Info_DetailsType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType removeZapi_Pax_Info_DetailsType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType)baseList().remove(index);
    }

    public int indexOfZapi_Pax_Info_DetailsType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType item) {
        return baseList().indexOf(item);
    }

    public boolean containsAllZapi_Pax_Info_DetailsType(Zapi_Pax_Info_DetailsType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType[] toArrayZapi_Pax_Info_DetailsType() {
        return (com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType[] {});
    }

    public boolean removeZapi_Pax_Info_DetailsType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType item) {
        return baseList().remove(item);
    }

    public Zapi_Pax_Info_DetailsType_List subListZapi_Pax_Info_DetailsType(int fromIndex, int toIndex) {
        return (Zapi_Pax_Info_DetailsType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addZapi_Pax_Info_DetailsType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType item) {
        baseList().add(item);
    }

    public boolean containsZapi_Pax_Info_DetailsType(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType setZapi_Pax_Info_DetailsType(int index, com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType item) {
        return (com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType)baseList().set(index, item);
    }

    public void addZapi_Pax_Info_DetailsType(int index, com.kcdata.abe.bapi.Zapi_Pax_Info_DetailsType item) {
        baseList().add(index, item);
    }

}
