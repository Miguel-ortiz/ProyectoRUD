<%-- 
  Documento : per_reg_ini
  Fecha de Creación : 5/02/2018, 04:16:35 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--<%@ taglib uri="http://primefaces.prime.com.tr/" prefix="p" %>--%>

<fmt:setBundle basename="proyecto.idiger.gov.co.utils.labels"/>
<!DOCTYPE html>
<c:choose>
    <c:when test="${not empty miUsuarioVO}">
        <c:import url='/includes/cabecera.jsp' />
        <c:set var="personaVO" value="${personaVO}" />
        <div class="boxes">
            <div class="form-group">
                <div class="input-group center-block">  
                    <input type="submit" onclick="location.href = '../menu/index.jsp'; return false;" value="Volver" alt="VOLVER" title="VOLVER" class="btn btn-primary"/>
                </div>
            </div>
            <br/>
            <form class="form" method="post" action="per_reg_ctr.jsp" autocomplete="off" id="FormAplication" name="FormAplication">
                <fieldset class="form-fieldset PaginarTabla">                
                    <legend class="text-center">Formulario Registro Persona</legend>
                    <div class="form-group col-xs-6 col-md-6">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.primernom' /><span>*</span> 
                            </div>
                            <input id="primernom_txt" name="primernom_txt" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-6 col-md-6">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.segundonom' /> 
                            </div>
                            <input id="segundonom_txt" name="segundonom_txt" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-6 col-md-6">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.primerape' /><span>*</span> 
                            </div>
                            <input id="primerape_txt" name="primerape_txt" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-6 col-md-6">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.segundoape' /> 
                            </div>
                            <input id="segundoape_txt" name="segundoape_txt" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-6 col-md-6">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.tipoDocumento' /><span>*</span></div>
                            <select class="form-control" id="tipodocumento_sel" name="tipodocumento_sel"  >
                                <option value="">--</option>
                                <c:forEach var="documentoIdentidadVOs" items="${documentoIdentidadVO}"  varStatus="i">
                                    <option value="${documentoIdentidadVOs.tpdo_id}">${documentoIdentidadVOs.tpdo_descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-xs-6 col-md-6">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.documento' /><span>*</span> 
                            </div>
                            <input id="documento_txt" name="documento_txt" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.parentesco' /></div>
                            <select class="form-control" id="parentesco_sel" name="parentesco_sel"  >
                                <option value="">--</option>
                                <c:forEach var="parentescoFamilarVOs" items="${parentescoFamilarVO}"  varStatus="i">
                                    <option value="${parentescoFamilarVOs.tpfa_id}">${parentescoFamilarVOs.tpfa_descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.genero' /><span>*</span> </div>
                            <select class="form-control" id="genero_sel" name="genero_sel" required >
                                <option value="">--</option>
                                <option value="M">Masculino</option>
                                <option value="I">Intergenero</option>
                                <option value="F">Femenino</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group" >
                            <div class="input-group-addon"><fmt:message key='label.afrocolom' /></div>
                            <select class="form-control" id="afrocolom_sel" name="afrocolom_sel"  >
                                <option value="">--</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.etnia' /></div>
                            <select class="form-control" id="etnia_sel" name="etnia_sel"  >
                                <option value="">--</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.edad' /></div>
                            <input id="edad_txt" name="edad_txt" class="form-control"  type="text" style="width: 95%">
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3"> 
                        <div class="input-group" >
                            <div class="input-group-addon" ><fmt:message key='label.fechaNaci' /></div>
                            <input id="fechanac_txt" name="fechanac_txt" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.numFamilia' /> 
                            </div>
                            <input id="numfamil_txt" name="numfamil_txt" class="form-control"  type="text" >
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.estadosalud' /><span>*</span> </div>
                            <select class="form-control" id="estadosalud_sel" name="estadosalud_sel" required>
                                <option value="">--</option>
                                <c:forEach var="estadoPostEventoVOs" items="${estadoPostEventoVO}"  varStatus="i">
                                    <option value="${estadoPostEventoVOs.epev_id}">${estadoPostEventoVOs.epev_descricion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.regisalud' /></div>
                            <select class="form-control" id="regisalud_sel" name="regisalud_sel"  >
                                <option value="">--</option>
                            </select>
                        </div>
                    </div>
                </fieldset>
                <br/>
                <center>
                    <div class="form-group">
                        <div class="input-group center-block">  
                            <input type="hidden" value="1" id="op" name="op" /> 
                            <input type="submit" value="Guardar Persona" class="btn btn-primary" />
                        </div>
                    </div>
                </center>
                <c:if test="${dato eq 'si'}">
                    <fieldset class="form-fieldset">
                        <body data-spy="scroll" data-target=".navbar" data-offset="50"></body>
                        <table style="margin: auto; text-align: center; " class="table table-bordered table-hover" cellspacing="1" cellpadding="0" border="1" id="tab2">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th><fmt:message key='label.nombre' /></th>
                                    <th><fmt:message key='label.apellido' /></th>
                                    <th><fmt:message key='label.tipoDocumento' /></th>
                                    <th><fmt:message key='label.documento' /></th>
                                    <th><fmt:message key='label.parentesco' /></th>
                                    <th><fmt:message key='label.genero' /></th>
                                    <th><fmt:message key='label.fechaNaci' /></th>
                                    <th><fmt:message key='label.edad' /></th>
                                    <th><fmt:message key='label.afrocolom' /></th>
                                    <th><fmt:message key='label.etnia' /></th>
                                    <th><fmt:message key='label.numFamilia' /></th>
                                    <th><fmt:message key='label.estadosalud' /></th>
                                    <th><fmt:message key='label.regisalud' /></th>
                                    <!--<th>Acciones</th>-->
                                </tr>
                            </thead>
                            <tbody style="text-align: center">
                                <c:set var="color" value="black" />
                                <c:forEach var="personaVOs" items="${personaVO}"  varStatus="i">
                                    <tr>
                                        <td style="text-align: center;"></td> 
                                        <td style="color: ${color}">${personaVOs.pege_primernombre}</td>
                                        <td style="color: ${color}">${personaVOs.pege_primerapellido}</td>
                                        <td style="color: ${color}">${personaVOs.tpdo_id}</td>
                                        <td style="color: ${color}">${personaVOs.pege_documento}</td>
                                        <td style="color: ${color}">${personaVOs.parn_id}</td>
                                        <td style="color: ${color}">${personaVOs.pege_genero}</td>
                                        <td style="color: ${color}">${personaVOs.pege_fechanaciniento}</td>
                                        <td style="color: ${color}">${personaVOs.pege_afrocolombia}</td>
                                        <td style="color: ${color}">${personaVOs.etni_descripcion}</td>
                                        <td style="color: ${color}">${personaVOs.regm_descripcion}</td>
                                        <td style="text-align: center;"></td> 
                                        <td style="text-align: center;"></td> 
                                        <td style="text-align: center;"></td> 
                                        <!--<td style="text-align: center;">Acciones</td>--> 
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                       </body>
                        <script>
                            var table = {
                                paging: true,
                                paging_length: 10,
                                alternate_rows: true,
                                col_0: "none",
                                col_1: "select",
                                rows_counter: true,
                                rows_counter_text: "Registros:",
                                results_per_page: ['# Registros', [10, 20]],
                                btn_reset: true,
                                enter_key: false,
                                sort_select: true,
                                on_keyup: true,
                                loader: true,
                                scroll: true
                            };
                            tf = setFilterGrid("tab2", table);
                            $('body').scrollspy({target: ".navbar"})
                        </script>
                        
                    </fieldset>
                </c:if>
            </form>
        </div>
        <c:import url='/includes/footer.jsp' />
    </c:when>
    <c:otherwise>
        <c:import url="/menu/fuera.jsp" />
    </c:otherwise>
</c:choose>
