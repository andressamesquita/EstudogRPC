package br.com.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Mateus")
        .setCpf("000.000.000-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(
            FuncionarioRequest.Endereco.newBuilder()
                .setLogradouro("Rua das Tabajaras")
                .setCep("00000-000")
                .setComplemento("Casa 20")
                .build()
        )
        .build()

    //escrevemos o objeto
    println(request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    //lemos o objeto
    val request2 = FuncionarioRequest.newBuilder()
                        .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENT).build()
    println(request2)

}