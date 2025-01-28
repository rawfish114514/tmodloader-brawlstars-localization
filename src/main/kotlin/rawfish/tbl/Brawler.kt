package rawfish.tbl

import org.hjson.JsonObject
import rawfish.tbl.brawlers.BIBI
import rawfish.tbl.brawlers.MEG
import rawfish.tbl.brawlers.MORTIS
import rawfish.tbl.brawlers.SHELLY

val brawlers = listOf(
    SHELLY::class,
    BIBI::class,
    MORTIS::class,
    MEG::class
)


abstract class Brawler : Seri {
    val brawlerID: String = javaClass.kotlin.simpleName ?: throw Exception()
    abstract fun brawlerWeapon(language: Language): String
    abstract val brawlerName: String
    abstract val brawlerInfo: BrawlerInfo

    override fun seri(language: Language): JsonObject {
        return JsonObject().apply {
            set(brawlerID, JsonObject().apply {
                set("${brawlerID}_Info", brawlerInfo.seri(language))
                set("${brawlerID}_Item", JsonObject().apply {
                    set(
                        "DisplayName",
                        language["EXT_POSSESSIVE_CASE"].format(language[brawlerName], brawlerWeapon(language))
                    )
                    set("Tooltip", "")
                })
            })
        }
    }

}

interface Seri {
    fun seri(language: Language): JsonObject
}

fun Map<String, String>.replace(str: String): String {
    var str1 = str
    forEach { (k, v) -> str1 = str1.replace(k, v) }
    return str1
}


@JvmName("wrapArraySeri")
private fun wrapArray(array: Collection<Seri>, language: Language): JsonObject {
    return JsonObject().apply {
        array.forEachIndexed { index, any ->
            set((index + 1).toString(), any.seri(language))
        }
    }
}

@JvmName("wrapArrayString")
private fun wrapArray(array: Collection<String>, language: Language): JsonObject {
    return JsonObject().apply {
        array.forEachIndexed { index, any ->
            set((index + 1).toString(), language[any])
        }
    }
}

class BrawlerInfo(
    val brawlerDescription: String,
    val heroes: List<HeroInfo>,
    val gadgets: List<GadgetInfo>,
    val starPowers: List<StarPowerInfo>
) : Seri {
    override fun seri(language: Language): JsonObject {
        return JsonObject().apply {
            set("BrawlerDescription", language[brawlerDescription])
            set("Heroes", wrapArray(heroes, language))
            set("Gadgets", wrapArray(gadgets, language))
            set("StarPowers", wrapArray(starPowers, language))
        }
    }
}

class HeroInfo(
    val traits: List<String>,
    val attack: AttackInfo,
    val `super`: SuperInfo,
    val hyperCharge: HyperChargeInfo
) : Seri {
    override fun seri(language: Language): JsonObject {
        return JsonObject().apply {
            set("Traits", wrapArray(traits, language))
            set("Attack", attack.seri(language))
            set("Super", `super`.seri(language))
            set("HyperCharge", hyperCharge.seri(language))
        }
    }
}

open class NdsInfo(
    val name: String,
    val description: String,
    val descriptionReplaces: Map<String, String>,
    val stats: List<StatInfo>,
) : Seri {
    override fun seri(language: Language): JsonObject {
        return JsonObject().apply {
            set("Name", language[name])
            set("Description", descriptionReplaces.replace(language[description]))
            set("Stats", wrapArray(stats, language))
        }
    }
}

class StatInfo(
    val key: String,
    val value: String,
    val valueReplaces: Map<String, String>
) : Seri {
    override fun seri(language: Language): JsonObject {
        return JsonObject().apply {
            set("Key", language[key])
            set("Value", valueReplaces.replace(language[value]))
        }
    }
}

open class NdInfo(
    val name: String,
    val description: String,
    val descriptionReplaces: Map<String, String>
) : Seri {
    override fun seri(language: Language): JsonObject {
        return JsonObject().apply {
            set("Name", language[name])
            set("Description", descriptionReplaces.replace(language[description]))
        }
    }
}

class AttackInfo(
    name: String,
    description: String,
    descriptionReplaces: Map<String, String>,
    stats: List<StatInfo>
) : NdsInfo(
    name,
    description,
    descriptionReplaces,
    stats
)

class SuperInfo(
    name: String,
    description: String,
    descriptionReplaces: Map<String, String>,
    stats: List<StatInfo>
) : NdsInfo(
    name,
    description,
    descriptionReplaces,
    stats
)

class HyperChargeInfo(
    name: String,
    description: String,
    descriptionReplaces: Map<String, String>,
    stats: List<StatInfo>
) : NdsInfo(
    name,
    description,
    descriptionReplaces,
    stats
)

class GadgetInfo(
    name: String,
    description: String,
    descriptionReplaces: Map<String, String>
) : NdInfo(
    name,
    description,
    descriptionReplaces
)

class StarPowerInfo(
    name: String,
    description: String,
    descriptionReplaces: Map<String, String>
) : NdInfo(
    name,
    description,
    descriptionReplaces
)

fun defaultHyperChargeStatInfos() = listOf(
    StatInfo(
        key = "TID_OVERCHARGE_STAT1_DESC",
        value = "TID_OVERCHARGE_STAT1_VALUE",
        valueReplaces = mapOf("<VALUE>" to "{0}")
    ),
    StatInfo(
        key = "TID_OVERCHARGE_STAT2_DESC",
        value = "TID_OVERCHARGE_STAT2_VALUE",
        valueReplaces = mapOf("<VALUE>" to "{0}")
    ),
    StatInfo(
        key = "TID_OVERCHARGE_STAT3_DESC",
        value = "TID_OVERCHARGE_STAT3_VALUE",
        valueReplaces = mapOf("<VALUE>" to "{0}")
    )
)

fun multiplierAttackDamageStatInfo() = StatInfo(
    key = "TID_HERO_INFO_ATTACK_DAMAGE",
    value = "TID_HERO_INFO_ATTACK_DAMAGE_MULTIPLIER",
    valueReplaces = mapOf(
        "<AMMO>" to "{0}",
        "<DAMAGE>" to "{1}"
    )
)

fun singleAttackDamageStatInfo() = StatInfo(
    key = "TID_STAT_DAMAGE",
    value = "{0}",
    valueReplaces = mapOf()
)

fun replaceValue(i: Int) = "<c00cc00><VALUE${i + 1}></c>" to "{${i}}"
fun replacePreCentValue(i: Int) = "<c00cc00><VALUE${i + 1}>%</c>" to "{${i}}"