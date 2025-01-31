package rawfish.tbl.brawlers

import rawfish.tbl.*

class SHELLY : Brawler() {
    override fun brawlerWeapon(language: Language): String = when (language) {
        Language.SimplifiedChinese -> "霰弹枪"
        Language.Russian -> "ружьём"
        else -> "Shotgun"
    }

    override val brawlerName: String = "TID_SHOTGUN_GIRL"
    override val brawlerInfo = BrawlerInfo(
        brawlerDescription = "TID_SHOTGUN_GIRL_DESC",
        heroes = listOf(
            HeroInfo(
                traits = listOf(),
                attack = AttackInfo(
                    name = "TID_LONG_RANGE_SHOTGUN",
                    description = "TID_LONG_RANGE_SHOTGUN_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        multiplierAttackDamageStatInfo()
                    )
                ),
                `super` = SuperInfo(
                    name = "TID_MEGA_BLASH_ULTI",
                    description = "TID_MEGA_BLASH_ULTI_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        multiplierAttackDamageStatInfo()
                    )
                ),
                hyperCharge = HyperChargeInfo(
                    name = "TID_SHOTGUNGIRL_OVERCHARGE",
                    description = "TID_SHOTGUNGIRL_OVERCHARGE_DESC",
                    descriptionReplaces = mapOf(
                        replaceValue(0)
                    ),
                    stats = defaultHyperChargeStatInfos()
                )
            )
        ),
        gadgets = listOf(
            GadgetInfo(
                name = "TID_ACCESSORY_SHELLY_DASH",
                description = "TID_ACCESSORY_SHELLY_DASH_DESC",
                descriptionReplaces = mapOf()
            ),
            GadgetInfo(
                name = "TID_ACCESSORY_SHELLY_FOCUS",
                description = "TID_ACCESSORY_SHELLY_FOCUS_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            )
        ),
        starPowers = listOf(
            StarPowerInfo(
                name = "TID_SPEC_ABI_FREEZE",
                description = "TID_SPEC_ABI_FREEZE_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            ),
            StarPowerInfo(
                name = "TID_SPEC_ABI_MEDIKIT",
                description = "TID_SPEC_ABI_MEDIKIT_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0),
                    replaceValue(1),
                    replaceValue(2)
                )
            )
        )
    )
}
