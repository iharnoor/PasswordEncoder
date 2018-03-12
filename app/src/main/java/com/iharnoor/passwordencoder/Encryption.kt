package com.iharnoor.passwordencoder

import java.util.HashMap

class Encryption {
    fun encode(message: String, key: Int): String {
        var message = caesarEncrypt(message, key)
        var chemStr = ""
        val chemSymbols = chemSymbols()
        for (i in 0..message.length - 1) {
            val currentChar = message[i]
            chemStr += chemSymbols.get(currentChar.toInt())
        }
        return chemStr
    }

    fun decode(message: String, key: Int): String {
        val chemU = chemSymbols()
        var output = ""
        var i = 0
        while (i < message.length) {
            val currentPair = message.substring(i, i + 2)
            if (chemU.containsValue(currentPair)) {
                val decoded = getKeyFromValue(chemU, currentPair) as Int
                val decoded2 = decoded.toChar()
                output += decoded2
            } else {
                println("Error finding the Value in HashMap")
                break
            }
            i += 2
        }
        val caesarDecoded = output
        output = caesarEncrypt(output, 26 - key)
        return output
    }

    fun getKeyFromValue(hm: HashMap<*, *>, value: Any): Any? {
        for (o in hm.keys)
            if (hm[o] == value)
                return o
        return null
    }

    private fun caesarEncrypt(message: String, key: Int): String {
        var i: Int
        var ch: Char
        val encoded = StringBuilder()
        i = 0
        while (i < message.length) {
            ch = message[i]
            if (ch in 'a'..'z') {//is lower case
                ch = ((ch - 'a' + key) % 26 + 'a'.toInt()).toChar()
                encoded.append(ch)
            } else if (ch in 'A'..'Z') {//is upper case
                ch = ((ch - 'A' + key) % 26 + 'A'.toInt()).toChar()
                encoded.append(ch)
            } else
                encoded.append(ch)
            ++i
        }
        return encoded.toString()
    }

    private fun chemSymbols(): HashMap<Int, String> {
        val chem = HashMap<Int, String>()
        chem.put(32, "Ds")
        chem.put(33, "Sc")
        chem.put(64, "Co")
        chem.put(63, "Ni")
        chem.put(46, "Cu")
        chem.put(47, "Zn")
        chem.put(69, "Ga")
        chem.put(70, "Ge")
        chem.put(71, "Bh")
        chem.put(48, "Rg")
        chem.put(49, "Re")
        chem.put(50, "Fr")
        chem.put(51, "Np")
        chem.put(52, "Rn")
        chem.put(53, "Tl")
        chem.put(54, "Lu")
        chem.put(55, "Pm")
        chem.put(56, "Ac")
        chem.put(57, "Ir")
        chem.put(65, "Os")
        chem.put(66, "At")
        chem.put(67, "Rf")
        chem.put(68, "Hf")
        chem.put(69, "Xe")
        chem.put(70, "Eu")
        chem.put(71, "As")
        chem.put(72, "Se")
        chem.put(73, "Br")
        chem.put(74, "Kr")
        chem.put(75, "Rb")
        chem.put(76, "Sr")
        chem.put(77, "Zr")
        chem.put(78, "Nb")
        chem.put(79, "Mo")
        chem.put(80, "Tc")
        chem.put(81, "Ru")
        chem.put(82, "Rh")
        chem.put(83, "Pd")
        chem.put(84, "Cd")
        chem.put(85, "In")
        chem.put(86, "Sn")
        chem.put(87, "Sb")
        chem.put(88, "Te")
        chem.put(89, "Cs")
        chem.put(90, "Ba")
        chem.put(97, "Lr")
        chem.put(98, "He")
        chem.put(99, "Li")
        chem.put(100, "Be")
        chem.put(101, "No")
        chem.put(102, "Md")
        chem.put(103, "Fm")
        chem.put(104, "Es")
        chem.put(105, "Cm")
        chem.put(106, "Ne")
        chem.put(107, "Na")
        chem.put(108, "Mg")
        chem.put(109, "Al")
        chem.put(110, "Si")
        chem.put(111, "Pu")
        chem.put(112, "Th")
        chem.put(113, "Cl")
        chem.put(114, "Ar")
        chem.put(115, "Gd")
        chem.put(116, "Ca")
        chem.put(117, "Mt")
        chem.put(118, "Ti")
        chem.put(119, "Ra")
        chem.put(120, "Cr")
        chem.put(121, "Mn")
        chem.put(122, "Fe")
        return chem
    }
}
