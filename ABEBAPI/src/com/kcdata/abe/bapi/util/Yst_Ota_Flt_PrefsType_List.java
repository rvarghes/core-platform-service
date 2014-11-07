package com.kcdata.abe.bapi.util;
public class Yst_Ota_Flt_PrefsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1256025777L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_FLT_PREFS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType(), new java.lang.String[][]{}, 5, 10, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_FLT_PREFS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Airline preferences</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>10</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Flt_PrefsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType removeYst_Ota_Flt_PrefsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType[] toArrayYst_Ota_Flt_PrefsType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType[] {});
    }

    public int lastIndexOfYst_Ota_Flt_PrefsType(com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Ota_Flt_PrefsType_List subListYst_Ota_Flt_PrefsType(int fromIndex, int toIndex) {
        return (Yst_Ota_Flt_PrefsType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType getYst_Ota_Flt_PrefsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType)baseList().get(index);
    }

    public void addAllYst_Ota_Flt_PrefsType(int index, Yst_Ota_Flt_PrefsType_List item) {
        baseList().addAll(index, item);
    }

    public int indexOfYst_Ota_Flt_PrefsType(com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType item) {
        return baseList().indexOf(item);
    }

    public void addAllYst_Ota_Flt_PrefsType(Yst_Ota_Flt_PrefsType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYst_Ota_Flt_PrefsType(Yst_Ota_Flt_PrefsType_List item) {
        return baseList().containsAll(item);
    }

    public boolean removeYst_Ota_Flt_PrefsType(com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_Flt_PrefsType(com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType item) {
        baseList().add(item);
    }

    public boolean containsYst_Ota_Flt_PrefsType(com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType setYst_Ota_Flt_PrefsType(int index, com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType)baseList().set(index, item);
    }

    public void addYst_Ota_Flt_PrefsType(int index, com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType item) {
        baseList().add(index, item);
    }

}
