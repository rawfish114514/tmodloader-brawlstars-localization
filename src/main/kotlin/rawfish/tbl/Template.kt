package rawfish.tbl

class Template : Brawler() {
    override fun brawlerWeapon(language: Language): String = when (language) {
        Language.SimplifiedChinese -> ""
        Language.Russian -> ""
        else -> ""
    }

    override val brawlerName: String = ""
    override val brawlerInfo = BrawlerInfo(
        brawlerDescription = "",
        heroes = listOf(
            HeroInfo(
                traits = listOf(),
                attack = AttackInfo(
                    name = "",
                    description = "",
                    descriptionReplaces = mapOf(),
                    stats = listOf()
                ),
                `super` = SuperInfo(
                    name = "",
                    description = "",
                    descriptionReplaces = mapOf(),
                    stats = listOf()
                ),
                hyperCharge = HyperChargeInfo(
                    name = "",
                    description = "",
                    descriptionReplaces = mapOf(),
                    stats = defaultHyperChargeStatInfos()
                )
            )
        ),
        gadgets = listOf(
            GadgetInfo(
                name = "",
                description = "",
                descriptionReplaces = mapOf()
            ),
            GadgetInfo(
                name = "",
                description = "",
                descriptionReplaces = mapOf()
            )
        ),
        starPowers = listOf(
            StarPowerInfo(
                name = "",
                description = "",
                descriptionReplaces = mapOf()
            ),
            StarPowerInfo(
                name = "",
                description = "",
                descriptionReplaces = mapOf()
            )
        )
    )
}
