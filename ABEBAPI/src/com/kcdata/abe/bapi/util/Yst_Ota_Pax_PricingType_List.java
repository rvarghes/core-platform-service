package com.kcdata.abe.bapi.util;
public class Yst_Ota_Pax_PricingType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -988350016L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_PAX_PRICING", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType.class, new com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType(), new java.lang.String[][]{}, 95, 102, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_PAX_PRICING\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Pax Pricing</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>95</ifr:internalLength1><ifr:internalLength2>102</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Pax_PricingType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int lastIndexOfYst_Ota_Pax_PricingType(com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType item) {
        return baseList().lastIndexOf(item);
    }

    public int indexOfYst_Ota_Pax_PricingType(com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType removeYst_Ota_Pax_PricingType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType)baseList().remove(index);
    }

    public void addAllYst_Ota_Pax_PricingType(int index, Yst_Ota_Pax_PricingType_List item) {
        baseList().addAll(index, item);
    }

    public boolean removeYst_Ota_Pax_PricingType(com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType item) {
        return baseList().remove(item);
    }

    public void addAllYst_Ota_Pax_PricingType(Yst_Ota_Pax_PricingType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType[] toArrayYst_Ota_Pax_PricingType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType[] {});
    }

    public void addYst_Ota_Pax_PricingType(com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType item) {
        baseList().add(item);
    }

    public boolean containsAllYst_Ota_Pax_PricingType(Yst_Ota_Pax_PricingType_List item) {
        return baseList().containsAll(item);
    }

    public Yst_Ota_Pax_PricingType_List subListYst_Ota_Pax_PricingType(int fromIndex, int toIndex) {
        return (Yst_Ota_Pax_PricingType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean containsYst_Ota_Pax_PricingType(com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType setYst_Ota_Pax_PricingType(int index, com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType)baseList().set(index, item);
    }

    public void addYst_Ota_Pax_PricingType(int index, com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType getYst_Ota_Pax_PricingType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType)baseList().get(index);
    }

}
