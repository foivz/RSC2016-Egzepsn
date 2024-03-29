﻿using AutoMapper;
using rsc2016Quiz.Dtos;

namespace rsc2016Quiz.Helpers
{
    public class ApiErrorHandler : IApiErrorHandler
    {
        public ErrorMessageDto GenerateErrorDto<T>(T model)
        {
            var errorMessage = Mapper.Map<ErrorMessageDto>(model);
            if (errorMessage.Errors.Count > 0)
            {
                errorMessage.Message = "Invalide model data";
                errorMessage.Code = 4000;
            }
            else
            {
                errorMessage.Code = 4005;
            }
            return errorMessage;
        }
    }
}
