package com.kcdata.abe.bapi;
public class Yzst_Add_Fli_SvcType extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1354264653906L) ;

    private  Yzst_Add_Fli_SvcType.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "YZST_ADD_FLI_SVC", 11, 0, com.kcdata.abe.bapi.Yzst_Add_Fli_SvcType.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "YZST_ADD_FLI_SVC", 98, 196, -1, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YZST_ADD_FLI_SVC\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Additional Flight Service Information. Returned if Option O.</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>98</ifr:internalLength1><ifr:internalLength2>196</ifr:internalLength2></ifr:definition></ifr:container></s0:type>");
        descriptorSetElementProperties(descriptor, 0, "DEP_TER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Dep_Ter", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "DEP_TER", 0, 0, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"DEP_TER\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Departure Terminal Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>0</ifr:offset1><ifr:offset2>0</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 1, "ARR_TER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Arr_Ter", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "ARR_TER", 2, 4, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ARR_TER\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Arrival Terminal Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>2</ifr:offset1><ifr:offset2>4</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 2, "ARR_ARP", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Arr_Arp", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ARR_ARP", 4, 8, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ARR_ARP\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Arrival Airport</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>4</ifr:offset1><ifr:offset2>8</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 3, "EQP_CHG_COD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Eqp_Chg_Cod", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "EQP_CHG_COD", 7, 14, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"EQP_CHG_COD\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Equipment change code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>7</ifr:offset1><ifr:offset2>14</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 4, "SPE_SVC_COD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Spe_Svc_Cod", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "SPE_SVC_COD", 8, 16, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SPE_SVC_COD\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Special service code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>8</ifr:offset1><ifr:offset2>16</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 5, "DOT_PER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Dot_Per", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "DOT_PER", 9, 18, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"DOT_PER\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">D. O. T. Performance</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>9</ifr:offset1><ifr:offset2>18</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 6, "LEG_MIL", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Leg_Mil", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "5"}}, "LEG_MIL", 11, 22, -1, 5, 10, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"LEG_MIL\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Leg miles</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>11</ifr:offset1><ifr:offset2>22</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>5</ifr:length><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>10</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 7, "GRO_TIM", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Gro_Tim", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "4"}}, "GRO_TIM", 16, 32, -1, 4, 8, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GRO_TIM\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Ground time (HHMM)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>16</ifr:offset1><ifr:offset2>32</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>4</ifr:length><ifr:internalLength1>4</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 8, "ELA_FLI_TIM", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ela_Fli_Tim", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "4"}}, "ELA_FLI_TIM", 20, 40, -1, 4, 8, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ELA_FLI_TIM\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Elapsed flight time. Ex. 342 (3 hours, 42 minutes), 1542 (15</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>20</ifr:offset1><ifr:offset2>40</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>4</ifr:length><ifr:internalLength1>4</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 9, "ACU_FLI_TIM", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Acu_Fli_Tim", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "4"}}, "ACU_FLI_TIM", 24, 48, -1, 4, 8, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ACU_FLI_TIM\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Accumulated flight time. Ex. 342 (3 hours, 42 minutes), 1542</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>24</ifr:offset1><ifr:offset2>48</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>4</ifr:length><ifr:internalLength1>4</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 10, "COM", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Com", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "70"}}, "COM", 28, 56, -1, 70, 140, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"COM\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Additional Comments</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>28</ifr:offset1><ifr:offset2>56</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>70</ifr:length><ifr:internalLength1>70</ifr:internalLength1><ifr:internalLength2>140</ifr:internalLength2><ifr:decimals>0</ifr:decimals></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        staticDescriptor = descriptor;
    }
    public  Yzst_Add_Fli_SvcType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Yzst_Add_Fli_SvcType (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setCom(java.lang.String Com) {
        baseTypeData().setElementValue(10, Com);
    }

    public java.lang.String getAcu_Fli_Tim() {
        return (java.lang.String)baseTypeData().getElementValueAsString(9);
    }

    public void setArr_Arp(java.lang.String Arr_Arp) {
        baseTypeData().setElementValue(2, Arr_Arp);
    }

    public void setEqp_Chg_Cod(java.lang.String Eqp_Chg_Cod) {
        baseTypeData().setElementValue(3, Eqp_Chg_Cod);
    }

    public void setLeg_Mil(java.lang.String Leg_Mil) {
        baseTypeData().setElementValue(6, Leg_Mil);
    }

    public void setGro_Tim(java.lang.String Gro_Tim) {
        baseTypeData().setElementValue(7, Gro_Tim);
    }

    public java.lang.String getDot_Per() {
        return (java.lang.String)baseTypeData().getElementValueAsString(5);
    }

    public void setEla_Fli_Tim(java.lang.String Ela_Fli_Tim) {
        baseTypeData().setElementValue(8, Ela_Fli_Tim);
    }

    public MetaData metadata() {
        return metadata;
    }

    public java.lang.String getArr_Ter() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public java.lang.String getSpe_Svc_Cod() {
        return (java.lang.String)baseTypeData().getElementValueAsString(4);
    }

    public java.lang.String getCom() {
        return (java.lang.String)baseTypeData().getElementValueAsString(10);
    }

    public java.lang.String getArr_Arp() {
        return (java.lang.String)baseTypeData().getElementValueAsString(2);
    }

    public void setDep_Ter(java.lang.String Dep_Ter) {
        baseTypeData().setElementValue(0, Dep_Ter);
    }

    public java.lang.String getEqp_Chg_Cod() {
        return (java.lang.String)baseTypeData().getElementValueAsString(3);
    }

    public void setAcu_Fli_Tim(java.lang.String Acu_Fli_Tim) {
        baseTypeData().setElementValue(9, Acu_Fli_Tim);
    }

    public java.lang.String getLeg_Mil() {
        return (java.lang.String)baseTypeData().getElementValueAsString(6);
    }

    public java.lang.String getGro_Tim() {
        return (java.lang.String)baseTypeData().getElementValueAsString(7);
    }

    public java.lang.String getEla_Fli_Tim() {
        return (java.lang.String)baseTypeData().getElementValueAsString(8);
    }

    public void setDot_Per(java.lang.String Dot_Per) {
        baseTypeData().setElementValue(5, Dot_Per);
    }

    public void setArr_Ter(java.lang.String Arr_Ter) {
        baseTypeData().setElementValue(1, Arr_Ter);
    }

    public java.lang.String getDep_Ter() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public void setSpe_Svc_Cod(java.lang.String Spe_Svc_Cod) {
        baseTypeData().setElementValue(4, Spe_Svc_Cod);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Yzst_Add_Fli_SvcType parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Yzst_Add_Fli_SvcType parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAcu_Fli_Tim() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEqp_Chg_Cod() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getLeg_Mil() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGro_Tim() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEla_Fli_Tim() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDot_Per() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getArr_Ter() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSpe_Svc_Cod() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCom() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getArr_Arp() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDep_Ter() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
