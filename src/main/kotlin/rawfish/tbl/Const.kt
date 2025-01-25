package rawfish.tbl

data class Language(val name: String, val code: String, var bFile: String = "", var tFile: String = "");

var languages: List<Language> = listOf(
    Language("English", "en-US","texts"),
    Language("German", "de-DE","de"),
    Language("Italian", "it-IT","it"),
    Language("French", "fr-FR","fr"),
    Language("Spanish", "es-ES","es"),
    Language("Russian", "ru-RU","ru"),
    Language("SimplifiedChinese", "zh-Hans","cn"),
    Language("BrazilianPortuguese", "pt-BR","pt"),
    Language("Polish", "pl-PL","pl"),
).onEach { language ->
    language.bFile += ".csv"
    language.tFile = language.code + "_Mods.brawlstars.hjson"
}
