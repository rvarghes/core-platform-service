package com.kcdata.abe.bapi.util;
public class Yst_Ota_Res_GuestinfoType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -821815111L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_RES_GUESTINFO", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType.class, new com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType(), new java.lang.String[][]{}, 944, 1888, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_RES_GUESTINFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Passenger Information</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>944</ifr:internalLength1><ifr:internalLength2>1888</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Res_GuestinfoType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addAllYst_Ota_Res_GuestinfoType(int index, Yst_Ota_Res_GuestinfoType_List item) {
        baseList().addAll(index, item);
    }

    public int indexOfYst_Ota_Res_GuestinfoType(com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType item) {
        return baseList().indexOf(item);
    }

    public void addAllYst_Ota_Res_GuestinfoType(Yst_Ota_Res_GuestinfoType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYst_Ota_Res_GuestinfoType(Yst_Ota_Res_GuestinfoType_List item) {
        return baseList().containsAll(item);
    }

    public boolean removeYst_Ota_Res_GuestinfoType(com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_Res_GuestinfoType(com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType removeYst_Ota_Res_GuestinfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType)baseList().remove(index);
    }

    public boolean containsYst_Ota_Res_GuestinfoType(com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType setYst_Ota_Res_GuestinfoType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType)baseList().set(index, item);
    }

    public void addYst_Ota_Res_GuestinfoType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType item) {
        baseList().add(index, item);
    }

    public Yst_Ota_Res_GuestinfoType_List subListYst_Ota_Res_GuestinfoType(int fromIndex, int toIndex) {
        return (Yst_Ota_Res_GuestinfoType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType getYst_Ota_Res_GuestinfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType)baseList().get(index);
    }

    public int lastIndexOfYst_Ota_Res_GuestinfoType(com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType[] toArrayYst_Ota_Res_GuestinfoType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType[] {});
    }

}
