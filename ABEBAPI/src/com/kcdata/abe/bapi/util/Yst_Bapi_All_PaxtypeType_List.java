package com.kcdata.abe.bapi.util;
public class Yst_Bapi_All_PaxtypeType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 94444635L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_ALL_PAXTYPE", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType.class, new com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType(), new java.lang.String[][]{}, 25, 34, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_ALL_PAXTYPE\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Show All Pax Type Pricing</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>25</ifr:internalLength1><ifr:internalLength2>34</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_All_PaxtypeType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType[] toArrayYst_Bapi_All_PaxtypeType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType[] {});
    }

    public com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType setYst_Bapi_All_PaxtypeType(int index, com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType)baseList().set(index, item);
    }

    public void addYst_Bapi_All_PaxtypeType(int index, com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Bapi_All_PaxtypeType(Yst_Bapi_All_PaxtypeType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_Bapi_All_PaxtypeType(com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Bapi_All_PaxtypeType(Yst_Bapi_All_PaxtypeType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_Bapi_All_PaxtypeType(com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType item) {
        baseList().add(item);
    }

    public void addAllYst_Bapi_All_PaxtypeType(int index, Yst_Bapi_All_PaxtypeType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType getYst_Bapi_All_PaxtypeType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType)baseList().get(index);
    }

    public boolean containsYst_Bapi_All_PaxtypeType(com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType item) {
        return baseList().contains(item);
    }

    public Yst_Bapi_All_PaxtypeType_List subListYst_Bapi_All_PaxtypeType(int fromIndex, int toIndex) {
        return (Yst_Bapi_All_PaxtypeType_List)baseList().subList(fromIndex, toIndex);
    }

    public int lastIndexOfYst_Bapi_All_PaxtypeType(com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType removeYst_Bapi_All_PaxtypeType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType)baseList().remove(index);
    }

    public int indexOfYst_Bapi_All_PaxtypeType(com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType item) {
        return baseList().indexOf(item);
    }

}
