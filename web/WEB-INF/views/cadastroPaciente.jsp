<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp"></jsp:include>
    <div class="row">
        <div class="main col-md-10 col-md-push-2">

            <div class="panel panel-default" style="margin:10px;">
                <div class="panel-heading">
                    <h3 class="panel-title">Cadastrar Paciente</h3>
                </div>
                <div class="panel-body">


                    <form action="" method="POST"  style="margin: 0% 0;">
                        <label>Nome Completo</label>
                        <input class="form-control" type="text" name="nomePaciente" placeholder="Nome Completo" />
                        <div class="row">
                            <div class="col-md-3">
                                <label>Tipo de Endere�o</label>
                                <select class="form-control" name="tipo_endere�o">
                                    <option value="AEROPORTO"></option>
                                    <option value="ALAMEDA">ALAMEDA</option>
                                    <option value="APARTAMENTO">APARTAMENTO</option>
                                    <option value="AVENIDA">AVENIDA</option>
                                    <option value="BECO">BECO</option>
                                    <option value="BLOCO">BLOCO</option>
                                    <option value="CAMINHO">CAMINHO</option>
                                    <option value="ESCADINHA">ESCADINHA</option>
                                    <option value="ESTACAO">ESTA��O</option>
                                    <option value="ESTRADA">ESTRADA</option>
                                    <option value="FAZENDA">FAZENDA</option>
                                    <option value="FORTALEZA">FORTALEZA</option>
                                    <option value="GALERIA">GALERIA</option>
                                    <option value="LADEIRA">LADEIRA</option>
                                    <option value="LARGO">LARGO</option>
                                    <option value="PRACA">PRA�A</option>
                                    <option value="PARQUE">PARQUE</option>
                                    <option value="PRAIA">PRAIA</option>
                                    <option value="QUADRA">QUADRA</option>
                                    <option value="QUILOMETRO">QUIL�METRO</option>
                                    <option value="QUINTA">QUINTA</option>
                                    <option value="RODOVIA">RODOVIA</option>
                                    <option value="RUA">RUA</option>
                                    <option value="SUPER QUADRA">SUPER QUADRA</option>
                                    <option value="TRAVESSIA">TRAVESSA</option>
                                    <option value="VIADUTO">VIADUTO</option>
                                    <option value="VILA">VILA</option>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <label>Endere�o</label>
                                <input class="form-control" type="text" name="endereco" placeholder="Endere�o" />
                            </div>
                            <div class="col-md-3">
                                <label>cep</label>
                                <input class="form-control" type="text" name="cep" placeholder="cep" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <label>Bairro</label>
                                <input class="form-control" type="text" name="bairro" placeholder="Bairro" />
                            </div>
                            <div class="col-md-4">
                                <label>Complemeto</label>
                                <input class="form-control" type="text" name="complemeto" placeholder="Complemento" />
                            </div>
                            <div class="col-md-2">
                                <label>N�mero</label>
                                <input class="form-control" type="text" name="numero" placeholder="N�mero" />
                            </div>
                            <div class="col-md-2">
                                <label>Sexo</label>
                                <select class="form-control" name="sexo">
                                    <option value="M">Masculino</option>
                                    <option value="F">Feminino</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-10">
                                <label>Cidade</label>
                                <select class="form-control" name="cidade">
                                <c:forEach var="cidade" items="${cidades}">
                                    <option value="${cidade.idcidade}">${cidade.cidade}</option>
                                </c:forEach>   
                            </select>
                        </div>
                        <div class="col-md-2">
                            <label>Estado</label>
                            <select class="form-control" name="estados-brasil">
                                <c:forEach var="estado" items="${estados}">
                                    <option value="${estado.sigla}">${estado.estado}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <label>CPF</label>
                            <input class="form-control" type="text" name="cpf" placeholder="CPF" />
                        </div>
                        <div class="col-md-4">
                            <label>Tipo Sanguineo</label>
                            <select class="form-control" name="tipoSanguineo">
                                <option value="A">A</option>
                                <option value="B">B</option>
                                <option value="AB">AB</option>
                                <option value="O">O</option>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <label>Fator RH</label>
                            <select class="form-control" name="fatorRH">
                                <option value="+">Positivo</option>
                                <option value="-">Negativo</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <label>Cart�o Conv�nio</label>
                            <input class="form-control" type="text" name="cartaoConvenio" placeholder="N�mero do SUS" />
                        </div>
                        <div class="col-md-4">
                            <label>Conv�nio</label>
                            <select class="form-control" name="convenio">
                                <c:forEach var="convenio" items="${convenios}">
                                    <option value="${convenio.idconvenio}">${convenio.empresaConvenio}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <label>Nascimento</label>
                            <input class="form-control" type="date" name="dataNascimento" placeholder="Data de Nascimento" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <label>Telefone</label>
                            <input class="form-control" type="tel" name="telefone" placeholder="Telefone" />
                        </div>
                        <div class="col-md-4">
                            <label>Celular</label>
                            <input class="form-control" type="tel" name="celular" placeholder="Celular" />
                        </div>
                        <div class="col-md-4">
                            <label>Email</label>
                            <input class="form-control" type="email" name="email" placeholder="Email" />
                        </div>
                    </div>
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary btn-lg pull-right"><span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> Salvar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="includes/menu.jsp"></jsp:include>
    <jsp:include page="includes/footer.jsp"></jsp:include>
