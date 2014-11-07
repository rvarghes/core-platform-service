package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Stopover_InfoType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1921926449L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_STOPOVER_INFO", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType(), new java.lang.String[][]{}, 109, 218, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_STOPOVER_INFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">List of Stopover Cities for BAPI</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>109</ifr:internalLength1><ifr:internalLength2>218</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Stopover_InfoType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addYst_Bapi_Stopover_InfoType(int index, com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType item) {
        baseList().add(index, item);
    }

    public Yst_Bapi_Stopover_InfoType_List subListYst_Bapi_Stopover_InfoType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Stopover_InfoType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean containsYst_Bapi_Stopover_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType item) {
        return baseList().contains(item);
    }

    public boolean removeYst_Bapi_Stopover_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType item) {
        return baseList().remove(item);
    }

    public void addAllYst_Bapi_Stopover_InfoType(int index, Yst_Bapi_Stopover_InfoType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYst_Bapi_Stopover_InfoType(Yst_Bapi_Stopover_InfoType_List item) {
        baseList().addAll(item);
    }

    public int indexOfYst_Bapi_Stopover_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType item) {
        return baseList().indexOf(item);
    }

    public boolean containsAllYst_Bapi_Stopover_InfoType(Yst_Bapi_Stopover_InfoType_List item) {
        return baseList().containsAll(item);
    }

    public int lastIndexOfYst_Bapi_Stopover_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType item) {
        return baseList().lastIndexOf(item);
    }

    public void addYst_Bapi_Stopover_InfoType(com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType getYst_Bapi_Stopover_InfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType removeYst_Bapi_Stopover_InfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType[] toArrayYst_Bapi_Stopover_InfoType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType[] {});
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType setYst_Bapi_Stopover_InfoType(int index, com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType)baseList().set(index, item);
    }

}
