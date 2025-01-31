package rawfish.tbl.brawlers

import rawfish.tbl.*

class MORTIS : Brawler() {
    override fun brawlerWeapon(language: Language): String = when (language) {
        Language.SimplifiedChinese -> "铲子"
        Language.Russian -> "лопата"
        else -> "Shovel"
    }

    override val brawlerName: String = "TID_UNDERTAKER"
    override val brawlerInfo = BrawlerInfo(
        brawlerDescription = "TID_UNDERTAKER_DESC",
        heroes = listOf(
            HeroInfo(
                traits = listOf(),
                attack = AttackInfo(
                    name = "TID_UNDERTAKER_WEAPON",
                    description = "TID_UNDERTAKER_WEAPON_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        singleAttackDamageStatInfo(),
                        StatInfo(
                            key = "TID_HERO_INFO_LONG_DASH_DELAY",
                            value = "EXT_TIME",
                            valueReplaces = mapOf()
                        )
                    )
                ),
                `super` = SuperInfo(
                    name = "TID_UNDERTAKER_ULTI",
                    description = "TID_UNDERTAKER_ULTI_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        singleAttackDamageStatInfo(),
                        StatInfo(
                            key = "TID_HERO_INFO_LIFE_STEAL",
                            value = "TID_HERO_INFO_ABILITY_POWER_PERCENT",
                            valueReplaces = mapOf(
                                "<BASEPOW>" to "{0}"
                            )
                        )
                    )
                ),
                hyperCharge = HyperChargeInfo(
                    name = "TID_UNDERTAKER_OVERCHARGE",
                    description = "TID_UNDERTAKER_OVERCHARGE_DESC",
                    descriptionReplaces = mapOf(),
                    stats = defaultHyperChargeStatInfos()
                )
            )
        ),
        gadgets = listOf(
            GadgetInfo(
                name = "TID_ACCESSORY_MORTIS_SWING",
                description = "TID_ACCESSORY_MORTIS_SWING_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            ),
            GadgetInfo(
                name = "TID_ACCESSORY_UNDERTAKER_RELOAD",
                description = "TID_ACCESSORY_UNDERTAKER_RELOAD_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            )
        ),
        starPowers = listOf(
            StarPowerInfo(
                name = "TID_SPEC_ABI_STEAL_SOULS",
                description = "TID_SPEC_ABI_STEAL_SOULS_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            ),
            StarPowerInfo(
                name = "TID_SPEC_ABI_LONGER_DASH",
                description = "TID_SPEC_ABI_LONGER_DASH_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            )
        )
    )
}