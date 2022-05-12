package dmar.akan.akademiaandroida.features.characters.domain

import dmar.akan.akademiaandroida.core.base.UseCase
import dmar.akan.akademiaandroida.features.characters.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}
