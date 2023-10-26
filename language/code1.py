import googletrans

LANGUAGES = {
    "af": "afrikaans",
    "sq": "albanian",
    "am": "amharic",
    "ar": "arabic",
    "hy": "armenian",
    "az": "azerbaijani",
    "eu": "basque",
    "be": "belarusian",
    "bn": "bengali",
    "bs": "bosnian",
    "bg": "bulgarian",
    "ca": "catalan",
    "ceb": "cebuano",
    "ny": "chichewa",
    "zh-cn": "chinese (simplified)",
    "zh-tw": "chinese (traditional)",
    "co": "corsican",
    "hr": "croatian",
    "cs": "czech",
    "da": "danish",
    "nl": "dutch",
    "en": "english",
    "eo": "esperanto",
    "et": "estonian",
    "tl": "filipino",
    "fi": "finnish",
    "fr": "french",
    "fy": "frisian",
    "gl": "galician",
    "ka": "georgian",
    "de": "german",
    "el": "greek",
    "gu": "gujarati",
    "ht": "haitian creole",
    "ha": "hausa",
    "haw": "hawaiian",
    "iw": "hebrew",
    "he": "hebrew",
    "hi": "hindi",
    "hmn": "hmong",
    "hu": "hungarian",
    "is": "icelandic",
    "ig": "igbo",
    "id": "indonesian",
    "ga": "irish",
    "it": "italian",
    "ja": "japanese",
    "jw": "javanese",
    "kn": "kannada",
    "kk": "kazakh",
    "km": "khmer",
    "ko": "korean",
    "ku": "kurdish (kurmanji)",
    "ky": "kyrgyz",
    "lo": "lao",
    "la": "latin",
    "lv": "latvian",
    "lt": "lithuanian",
    "lb": "luxembourgish",
    "mk": "macedonian",
    "mg": "malagasy",
    "ms": "malay",
    "ml": "malayalam",
    "mt": "maltese",
    "mi": "maori",
    "mr": "marathi",
    "mn": "mongolian",
    "my": "myanmar (burmese)",
    "ne": "nepali",
    "no": "norwegian",
    "or": "odia",
    "ps": "pashto",
    "fa": "persian",
    "pl": "polish",
    "pt": "portuguese",
    "pa": "punjabi",
    "ro": "romanian",
    "ru": "russian",
    "sm": "samoan",
    "gd": "scots gaelic",
    "sr": "serbian",
    "st": "sesotho",
    "sn": "shona",
    "sd": "sindhi",
    "si": "sinhala",
    "sk": "slovak",
    "sl": "slovenian",
    "so": "somali",
    "es": "spanish",
    "su": "sundanese",
    "sw": "swahili",
    "sv": "swedish",
    "tg": "tajik",
    "ta": "tamil",
    "te": "telugu",
    "th": "thai",
    "tr": "turkish",
    "uk": "ukrainian",
    "ur": "urdu",
    "ug": "uyghur",
    "uz": "uzbek",
    "vi": "vietnamese",
    "cy": "welsh",
    "xh": "xhosa",
    "yi": "yiddish",
    "yo": "yoruba",
    "zu": "zulu",
}


# firist letter in codeing to captal letter
def atoz(a_z="", resualt=""):
    for i in range(len(a_z)):
        if i == -1:
            if 96 < ord(a_z[i]) < 122:
                resualt += chr(ord(a_z[i]) - 32)
        elif 64 < ord(a_z[i]) < 91:
            resualt += chr(ord(a_z[i]) + 32)
        else:
            resualt += a_z[i]
    return resualt


# to find the translated text= doe not work properly
def findme(storage):
    sub = ""
    for line in storage:
        if ":" in line and "\n" in line:
            return sub
        sub += line


def what():
    translator = googletrans.Translator()
    unlike = 0
    for l in range(ord("a"), ord("z") + 1):
        i = 0
        storage = []
        lang = a_z("zulu")
        with open("sample.txt", "r") as file:
            for line in file:
                storage.append(line.rstrip())
                sub_storage = storage[i].split(":")
                try:
                    translted = translator.translate(sub_storage[0], dest=lang)
                    tanslater_sto = translator.translate(translted.text, dest="en")
                    Value = translted.text
                    if line == tanslater_sto.text:
                        storage[i] += ":" + Value + "\n"
                    else:
                        unlike += 1
                        storage[i] += ":" + Value + "\n"

                    i += 1
                except:
                    print(f"network is not working and {chr(l)} is not translated")

        with open("sample.txt", "w", encoding="utf-8") as f:
            f.write("".join(storage))
        print(f"{chr(l)} is translated")


def a_z(a_z="", resualt=""):
    for i in range(len(a_z)):
        if 64 < ord(a_z[i]) < 91:
            resualt += chr(ord(a_z[i]) + 32)
            continue
        if i == 2:
            return resualt
        resualt += a_z[i]


what()
