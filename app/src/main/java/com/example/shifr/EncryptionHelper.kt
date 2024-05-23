package com.example.shifr

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


class EncryptionHelper(private val key:String) {

    fun encrypt(textToEncrypt:String): String{
        val chiper = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val keySpec = SecretKeySpec(key.toByteArray(),"AES")
        val ivSpec = IvParameterSpec(key.toByteArray())
        chiper.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)
        val encryptedBytes = chiper.doFinal(textToEncrypt.toByteArray())
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT).toString()
    }

    fun decrypt(encrpyedtext:String):String{
        val chiper = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val keySpec = SecretKeySpec(key.toByteArray(),"AES")
        val ivSpec = IvParameterSpec(key.toByteArray())
        chiper.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)
        val encryptedBytes = Base64.decode(encrpyedtext, Base64.DEFAULT)
        val decryptBytes = chiper.doFinal(encryptedBytes)
        return String(decryptBytes)
    }
}