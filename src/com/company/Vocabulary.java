package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Vocabulary {

    VocabularyEntry[] vocabularyEntries;
    int currentEntryIdx = 0;

    public Vocabulary(VocabularyEntry[] vocabularyEntries)
    {
        this.vocabularyEntries = vocabularyEntries;
    }

    public VocabularyEntry GetRandomEntry()
    {
        double sum = 0;
        for (int i = 0; i < vocabularyEntries.length; i++) {
            sum += vocabularyEntries[i].frequency;
        }

        double b = Math.random() * sum;
        sum = 0;
        int idx;
        for (idx = 0; idx < vocabularyEntries.length; idx++) {
            sum += vocabularyEntries[idx].frequency;
            if (sum > b)
                break;
        }

        currentEntryIdx = idx;
        return vocabularyEntries[idx];
    }

    public Boolean evaluate(String answer)
    {
        var e = vocabularyEntries[currentEntryIdx];
        if (e.correctAnswer.equals(answer))
        {
            e.frequency = Math.min(1, e.frequency / 2);
            return true;
        }
        else
        {
            e.frequency *= 4;
            return false;
        }
    }

    public static Vocabulary getHiragana()
    {
        var hiragana = new String[] {
        "あ",
        "a", "い",
        "i", "う",
        "u", "え",
        "e", "お",
        "o", "か",
        "ka","き",
        "ki","く",
        "ku","け",
        "ke","こ",
        "ko","が",
        "ga","ぎ",
        "gi","ぐ",
        "gu","げ",
        "ge","ご",
        "go","さ",
        "sa","し",
        "shi","す",
        "su","せ",
        "se","そ",
        "so","ざ",
        "za","じ",
        "ji","ず",
        "zu","ぜ",
        "ze","ぞ",
        "zo","た",
        "ta","ち",
        "chi","つ",
        "tsu","て",
        "te","と",
        "to","だ",
        "da","ぢ",
        "ji","づ",
        "zu","で",
        "de","ど",
        "do","な",
        "na","に",
        "ni","ぬ",
        "nu","ね",
        "ne","の",
        "no","は",
        "ha","ひ",
        "hi","ふ",
        "fu","へ",
        "he","ほ",
        "ho","ば",
        "ba","び",
        "bi","ぶ",
        "bu","べ",
        "be","ぼ",
        "bo","ぱ",
        "pa","ぴ",
        "pi","ぷ",
        "pu","ぺ",
        "pe","ぽ",
        "po","ま",
        "ma","み",
        "mi","む",
        "mu","め",
        "me","も",
        "mo","や",
        "ya","ゆ",
        "yu","よ",
        "yo","ら",
        "ra","り",
        "ri","る",
        "ru","れ",
        "re","ろ",
        "ro","わ",
        "wa","を",
        "wo","ん",
        "n","きゃ",
        "kya","きゅ",
        "kyu","きょ",
        "kyo","ぎゃ",
        "gya","ぎゅ",
        "gyu","ぎょ",
        "gyo","しゃ",
        "sha","しゅ",
        "shu","しょ",
        "sho","じゃ",
        "ja","じゅ",
        "ju","じょ",
        "jo","ちゃ",
        "cha","ちゅ",
        "chu","ちょ",
        "cho","にゃ",
        "nya","にゅ",
        "nyu","にょ",
        "nyo","ひゃ",
        "hya","ひゅ",
        "hyu","ひょ",
        "hyo","びゃ",
        "bya","びゅ",
        "byu","びょ",
        "byo","ぴゃ",
        "pya","ぴゅ",
        "pyu","ぴょ",
        "pyo","みゃ",
        "mya","みゅ",
        "myu","みょ",
        "myo","りゃ",
        "rya","りゅ",
        "ryu","りょ",
        "ryo"};

        VocabularyEntry[] vect = new VocabularyEntry[hiragana.length / 2];
        for (int i = 0; i < hiragana.length; i+=2) {
                vect[i / 2] = new VocabularyEntry(hiragana[i], hiragana[i+1]);
        }
        return new Vocabulary(vect);
    }

    public static Vocabulary getKatakana()
    {
        var katakana = new String[] {"ア","a","イ","i","ウ","u","エ","e","オ","o","カ","ka","キ","ki","ク","ku","ケ","ke","コ","ko","ガ","ga","ギ","gi","グ","gu","ゲ","ge","ゴ","go","サ","sa","シ","shi","ス","su","セ","se","ソ","so","ザ","za","ジ","ji","ズ","zu","ゼ","ze","ゾ","zo","タ","ta","チ","chi","ツ","tsu","テ","te","ト","to","ダ","da","ヂ","ji","ヅ","dzu","デ","de","ド","do","ナ","na", "ニ", "ni", "ヌ", "nu", "ネ", "ne", "ノ", "no", "ハ", "ha", "ヒ", "hi", "フ", "fu", "ヘ", "he", "ホ", "ho", "バ", "ba", "ビ", "bi", "ブ", "bu", "ベ", "be", "ボ", "bo", "パ", "pa", "ピ", "pi", "プ", "pu", "ペ", "pe", "ポ", "po", "マ", "ma", "ミ", "mi", "ム", "mu", "メ", "me", "モ", "mo", "ヤ", "ya", "ユ", "yu", "ヨ", "yo", "ラ", "ra", "リ", "ri", "ル", "ru", "レ", "re", "ロ", "ro", "ワ", "wa", "ヲ", "wo", "ン", "n",
                "キャ", "kya",
                "キュ", "kyu",
                "キョ", "kyo",
                "ギャ", "gya",
                "ギュ", "gyu",
                "ギョ", "gyo",
                "シャ", "sha",
                "シュ", "shu",
                "ショ", "sho",
                "ジャ", "ja",
                "ジュ", "ju",
                "ジョ", "jo",
                "チャ", "cha",
                "チュ", "chu",
                "チョ", "cho",
                "ニャ", "nya",
                "ニュ", "nyu",
                "ニョ", "nyo",
                "ヒャ", "hya",
                "ヒュ", "hyu",
                "ヒョ", "hyo",
                "ビャ", "bya",
                "ビュ", "byu",
                "ビョ", "byo",
                "ピャ", "pya",
                "ピュ", "pyu",
                "ピョ", "pyo",
                "ミャ", "mya",
                "ミュ", "myu",
                "ミョ", "myo",
                "リャ", "rya",
                "リュ", "ryu",
                "リョ", "ryo"};

        VocabularyEntry[] vect = new VocabularyEntry[katakana.length / 2];
        for (int i = 0; i < katakana.length; i+=2) {
            vect[i / 2] = new VocabularyEntry(katakana[i].trim(), katakana[i+1].trim());
        }
        return new Vocabulary(vect);
    }
}
