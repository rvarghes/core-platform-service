package com.kcdata.abe.bapi.util;
public class Yst_Ota_ChargesType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -16637583L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_CHARGES", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_ChargesType.class, new com.kcdata.abe.bapi.Yst_Ota_ChargesType(), new java.lang.String[][]{}, 443, 870, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_CHARGES\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Booking Charges</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>443</ifr:internalLength1><ifr:internalLength2>870</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_ChargesType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Ota_ChargesType removeYst_Ota_ChargesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_ChargesType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Ota_ChargesType[] toArrayYst_Ota_ChargesType() {
        return (com.kcdata.abe.bapi.Yst_Ota_ChargesType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_ChargesType[] {});
    }

    public int lastIndexOfYst_Ota_ChargesType(com.kcdata.abe.bapi.Yst_Ota_ChargesType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Ota_ChargesType_List subListYst_Ota_ChargesType(int fromIndex, int toIndex) {
        return (Yst_Ota_ChargesType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Ota_ChargesType getYst_Ota_ChargesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_ChargesType)baseList().get(index);
    }

    public void addAllYst_Ota_ChargesType(int index, Yst_Ota_ChargesType_List item) {
        baseList().addAll(index, item);
    }

    public int indexOfYst_Ota_ChargesType(com.kcdata.abe.bapi.Yst_Ota_ChargesType item) {
        return baseList().indexOf(item);
    }

    public void addAllYst_Ota_ChargesType(Yst_Ota_ChargesType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYst_Ota_ChargesType(Yst_Ota_ChargesType_List item) {
        return baseList().containsAll(item);
    }

    public boolean removeYst_Ota_ChargesType(com.kcdata.abe.bapi.Yst_Ota_ChargesType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_ChargesType(com.kcdata.abe.bapi.Yst_Ota_ChargesType item) {
        baseList().add(item);
    }

    public boolean containsYst_Ota_ChargesType(com.kcdata.abe.bapi.Yst_Ota_ChargesType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_ChargesType setYst_Ota_ChargesType(int index, com.kcdata.abe.bapi.Yst_Ota_ChargesType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_ChargesType)baseList().set(index, item);
    }

    public void addYst_Ota_ChargesType(int index, com.kcdata.abe.bapi.Yst_Ota_ChargesType item) {
        baseList().add(index, item);
    }

}
